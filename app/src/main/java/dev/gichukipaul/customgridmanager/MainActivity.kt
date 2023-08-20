package dev.gichukipaul.customgridmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import dev.gichukipaul.customgridmanager.Utils.CustomLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainRecyclerView = findViewById<RecyclerView>(R.id.MainActivityRecyclerView)

        //  SET THE LAYOUT MANAGER
        val layoutManager = CustomLayoutManager(this, 2, 5, true)
        mainRecyclerView.layoutManager = layoutManager

        // TODO: SET THE ADAPTER ON THE RECYCLERVIEW

    }
}