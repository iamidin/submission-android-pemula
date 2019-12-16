package com.iamidin.dureners

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import Fruit
import com.bumptech.glide.request.RequestOptions


class ListFruitAdapter(val listFruit: ArrayList<Fruit>) :
    RecyclerView.Adapter<ListFruitAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_fruit, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, from, photo) = listFruit[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvFrom.text = from

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listFruit[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int {
        return listFruit.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Fruit)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_description_mini)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}