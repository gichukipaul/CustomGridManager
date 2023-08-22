package dev.gichukipaul.customgridmanager.Utils

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

interface OnSnapPositionChangeListener {
    fun onSnapPositionChange(position: Int)
}

class SnapOnScrollListener(
    private val snapHelper: SnapHelper,
    private val behavior: Behavior = Behavior.NOTIFY_ON_SCROLL,
    private val onSnapPositionChangeListener: OnSnapPositionChangeListener
) : RecyclerView.OnScrollListener() {

    private var snapPosition = RecyclerView.NO_POSITION

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (behavior == Behavior.NOTIFY_ON_SCROLL) {
            updateSnapPosition(recyclerView)
        }
    }

    private fun updateSnapPosition(recyclerView: RecyclerView) {
        val layoutManager = recyclerView.layoutManager
        if (layoutManager != null) {
            val snapView = snapHelper.findSnapView(layoutManager)
            if (snapView != null) {
                val snapPosition = layoutManager.getPosition(snapView)
                if (this.snapPosition != snapPosition) {
                    onSnapPositionChangeListener.onSnapPositionChange(snapPosition)
                    this.snapPosition = snapPosition
                    Log.d("updateSnapPosition: ", snapPosition.toString())
                }
            }
        }
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (newState == RecyclerView.SCROLL_STATE_IDLE && behavior == Behavior.NOTIFY_ON_SCROLL_STATE_IDLE) {
            updateSnapPosition(recyclerView)
        }
    }

    enum class Behavior {
        NOTIFY_ON_SCROLL,
        NOTIFY_ON_SCROLL_STATE_IDLE
    }

}