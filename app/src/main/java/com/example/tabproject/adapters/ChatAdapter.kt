package com.example.tabproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.tabproject.dataclasses.DataChat
import com.example.tabproject.R


class ChatAdapter(private val items: ArrayList<DataChat>) :
    RecyclerView.Adapter<ChatAdapter.ItemViewHolder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder1 {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_chat, parent, false)
        return ItemViewHolder1(view)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: ItemViewHolder1, position: Int) {
        holder.titleImage.setImageResource(items[position].image)
        holder.tview.text = items[position].name
        holder.tview1.text = items[position].msg
        holder.time2.text = items[position].timeC
    }

    inner class ItemViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleImage: ImageView = itemView.findViewById(R.id.ch_img1)
        val tview: TextView = itemView.findViewById(R.id.ch_tv1)
        val tview1: TextView = itemView.findViewById(R.id.ch_tv2)
        val time2: TextView = itemView.findViewById(R.id.ch_time)

    }
}
