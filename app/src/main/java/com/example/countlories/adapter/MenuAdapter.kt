package com.example.countlories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countlories.data.model.MenuModel
import com.example.countlories.databinding.ItemFavBinding


class MenuAdapter(private val listMenu: ArrayList<MenuModel>) : RecyclerView.Adapter<MenuAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemFavBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemFavBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listMenu.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val menu = listMenu[position]

        holder.binding.apply {
            favTitle.text = menu.name
            favCalories.text = menu.calorie
            Glide.with(favImg.context)
                .load(menu.imageUrl)
                .into(favImg)
        }
    }
}