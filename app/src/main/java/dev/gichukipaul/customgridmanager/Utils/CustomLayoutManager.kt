package dev.gichukipaul.customgridmanager.Utils

import android.content.Context
import android.graphics.PointF
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider

class CustomLayoutManager(
    private val context: Context,
    private val rows: Int,
    private val columns: Int,
    private val isReversed: Boolean
) : GridLayoutManager(context, rows, RecyclerView.HORIZONTAL, isReversed), ScrollVectorProvider {

    override fun computeScrollVectorForPosition(targetPosition: Int): PointF {
        return PointF(1f, 0f)
    }

    fun smoothScrollToPage(pageIndex: Int) {
        val smoothScroller = object : LinearSmoothScroller(context) {
            override fun computeScrollVectorForPosition(targetPosition: Int): PointF {
                return this@CustomLayoutManager.computeScrollVectorForPosition(targetPosition)
            }
        }
        smoothScroller.targetPosition = (pageIndex * rows * columns)
        startSmoothScroll(smoothScroller)
    }
}