package dev.gichukipaul.customgridmanager.Utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

class CustomSnap : SnapHelper() {

    override fun calculateDistanceToFinalSnap(layoutManager: RecyclerView.LayoutManager, targetView: View): IntArray {
        return intArrayOf(0, 0)
    }

    override fun findTargetSnapPosition(layoutManager: RecyclerView.LayoutManager, velocityX: Int, velocityY: Int): Int {
        val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
        val snapPosition = layoutManager.getPosition(snapView)
        return if (snapPosition == RecyclerView.NO_POSITION) RecyclerView.NO_POSITION else snapPosition
    }

    override fun findSnapView(layoutManager: RecyclerView.LayoutManager): View? {
        return layoutManager.getChildAt(0)
    }
}
