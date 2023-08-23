package dev.gichukipaul.customgridmanager.Utils

import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class CustomSnap(private val rows: Int, private val columns: Int) : PagerSnapHelper() {

    // Change the sensitivity of the swiping. Smaller figures makes it swipe on small fling gestures.
    companion object {
        private const val MINIMUM_SCROLL_THRESHOLD = 0.1
    }

    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager,
        velocityX: Int,
        velocityY: Int
    ): Int {
        val currentSnapPosition = super.findTargetSnapPosition(layoutManager, velocityX, velocityY)
        if (currentSnapPosition != RecyclerView.NO_POSITION) {
            val currentRow = currentSnapPosition / columns
            val currentPage = currentRow * columns
            val itemsPerPage = rows * columns

            // Calculate the threshold for snapping based on scroll distance
            val scrollThreshold = layoutManager.width * MINIMUM_SCROLL_THRESHOLD

            val nextPage = when {
                velocityX > scrollThreshold -> currentPage + columns  // Scroll to the right
                velocityX < -scrollThreshold -> currentPage - columns // Scroll to the left
                else -> currentSnapPosition
            }
            return nextPage.coerceIn(0, layoutManager.itemCount - 1)
        }
        return currentSnapPosition
    }
}