package dev.gichukipaul.customgridmanager.Utils

import android.content.Context
import android.graphics.PointF
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

class CustomLayoutManager(
    private val context: Context,
    private val recyclerView: RecyclerView,
    private val rows: Int,
    private val columns: Int,
    private val isReversed: Boolean
) : GridLayoutManager(context, rows, RecyclerView.HORIZONTAL, isReversed),
    OnSnapPositionChangeListener {

    private var snap: CustomSnap
    private var snapOnScrollListener: SnapOnScrollListener

    init {
        snap = CustomSnap(rows, columns)
        snapOnScrollListener = SnapOnScrollListener(
            snap,
            SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL_STATE_IDLE,
            this
        )
        recyclerView.addOnScrollListener(snapOnScrollListener)

        snap.attachToRecyclerView(recyclerView)
    }

    override fun computeScrollVectorForPosition(targetPosition: Int): PointF {
        val direction = if (isReversed) -1f else 1f
        return PointF(direction, 0f)
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

    override fun onSnapPositionChange(position: Int) {
        val itemsPerPage = rows * columns
        val currentPage = position / itemsPerPage
        val nextPageStart = currentPage * itemsPerPage

        val smoothScroller = object : LinearSmoothScroller(context) {
            override fun computeScrollVectorForPosition(targetPosition: Int): PointF {
                return this@CustomLayoutManager.computeScrollVectorForPosition(targetPosition)
            }
        }
        // If reversed, we adjust to snap to the end of the page
        if (isReversed) {
            smoothScroller.targetPosition = nextPageStart + (rows * columns) - 1
        } else {
            smoothScroller.targetPosition = nextPageStart
        }
        startSmoothScroll(smoothScroller)
    }
}