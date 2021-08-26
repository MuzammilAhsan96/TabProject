package com.example.tabproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.tabproject.dataclasses.DataCall
import com.example.tabproject.R


class CallAdapter(private val items: ArrayList<DataCall>) :
    RecyclerView.Adapter<CallAdapter.ItemViewHolder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder1 {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_calls, parent, false)
        return ItemViewHolder1(view)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: ItemViewHolder1, position: Int) {
        holder.titleImage.setImageResource(items[position].image)
        holder.tview.text = items[position].name
        holder.tview1.text = items[position].msg
        holder.callImage.setImageResource(items[position].img)
        holder.tagImage.setImageResource(items[position].img1)
    }

    inner class ItemViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleImage: ImageView = itemView.findViewById(R.id.ca_img1)
        val tview: TextView = itemView.findViewById(R.id.ca_tv1)
        val tview1: TextView = itemView.findViewById(R.id.ca_tv2)
        var callImage: ImageView = itemView.findViewById(R.id.ca_imgCall)
        var tagImage: ImageView = itemView.findViewById(R.id.ca_imgTag)

    }
}
