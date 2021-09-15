package com.example.guest.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guest.R
import com.example.guest.model.GuestModel
import com.example.guest.view.listener.GuestListener

class GuestViewHolder(itemView: View, private val listener: GuestListener): RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name

        textName.setOnClickListener{
            listener.onClick(guest.id)
        }
    }
}