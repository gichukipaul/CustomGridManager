package dev.gichukipaul.customgridmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import dev.gichukipaul.customgridmanager.Adapters.MainRecyclerAdapter
import dev.gichukipaul.customgridmanager.Utils.CustomLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainRecyclerView = findViewById<RecyclerView>(R.id.MainActivityRecyclerView)

        //  SET THE LAYOUT MANAGER
        val layoutManager = CustomLayoutManager(this, mainRecyclerView, 2, 5, false)
        mainRecyclerView.layoutManager = layoutManager

        // SAMPLE DATA FOR THE RECYCLERVIEW
        val itemList: List<String> = (1..40).map { "Item $it" }

        // SET THE ADAPTER ON THE RECYCLERVIEW
        val adapter = MainRecyclerAdapter(itemList)
        mainRecyclerView.adapter = adapter
    }

}