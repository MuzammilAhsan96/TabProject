package com.example.tabproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.tabproject.dataclasses.DataStatus
import com.example.tabproject.R


class StatusAdapter(private val items: ArrayList<DataStatus>) :
    RecyclerView.Adapter<StatusAdapter.ItemViewHolder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder1 {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.first_item_view_status, parent, false)
        return ItemViewHolder1(view)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: ItemViewHolder1, position: Int) {
        holder.titleImage.setImageResource(items[position].image)
        holder.titleImage2.setImageResource(items[position].image1)
        holder.tview.text = items[position].name
        holder.time2.text = items[position].timeC
    }

    inner class ItemViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleImage: ImageView = itemView.findViewById(R.id.st_img1)
        var titleImage2: ImageView = itemView.findViewById(R.id.st_img2)
        val tview: TextView = itemView.findViewById(R.id.st_tv1)
        val time2: TextView = itemView.findViewById(R.id.st_time)

    }
}
