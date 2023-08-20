package dev.gichukipaul.customgridmanager.Utils

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

class CustomLayoutManager(
    context: Context,
    private val rows: Int,
    private val columns: Int,
    private val isReversed: Boolean
) : RecyclerView.LayoutManager() {
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        TODO("Not yet implemented")
    }

}