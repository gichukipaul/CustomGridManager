package dev.gichukipaul.customgridmanager.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.gichukipaul.customgridmanager.R

class MainRecyclerAdapter(private val listItems: List<String>) :
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textHolder: TextView

        init {
            textHolder = itemView.findViewById(R.id.item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItems[position]
        holder.textHolder.text = item
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}