package com.example.guest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guest.R
import com.example.guest.model.GuestModel
import com.example.guest.view.viewholder.GuestViewHolder

class GuestAdapter: RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuests: List<GuestModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest, parent, false)
        return GuestViewHolder(item)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuests[position])
    }

    override fun getItemCount(): Int {
        return mGuests.count()
    }

    fun updateGuests(list: List<GuestModel>) {
        mGuests = list
        notifyDataSetChanged()
    }
}