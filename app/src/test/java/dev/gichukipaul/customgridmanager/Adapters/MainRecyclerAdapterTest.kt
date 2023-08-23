package dev.gichukipaul.customgridmanager.Adapters

import org.junit.Test

internal class MainRecyclerAdapterTest {

    @Test
    fun getItemCount() {
        val itemList = listOf("Item 1", "Item 2", "Item 3")
        val sut_adapter = MainRecyclerAdapter(itemList)

        assert(sut_adapter.itemCount == itemList.size)
    }
}