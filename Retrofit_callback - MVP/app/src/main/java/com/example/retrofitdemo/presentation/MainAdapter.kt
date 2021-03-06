package com.example.retrofitdemo.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.data.model.AlbumsItem
import com.example.retrofitdemo.databinding.ListItemBinding

class MainAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val albumsList = Albums()

    fun setList(list: Albums) {
        albumsList.clear()
        albumsList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ListItemBinding =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(albumsList[position])
    }

    override fun getItemCount(): Int = albumsList.size
}

class MyViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(albumsItem: AlbumsItem) {
        with(binding) {
            idTextView.text = albumsItem.id.toString()
            titleTextView.text = albumsItem.title
            userIdTextView.text = albumsItem.userId.toString()
        }
    }
}