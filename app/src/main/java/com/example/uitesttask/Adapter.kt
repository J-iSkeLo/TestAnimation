package com.example.uitesttask

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uitesttask.databinding.ItemBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolderData>()  {

    private var dataList = emptyList<Data>()

    class ViewHolderData(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(dataList: List<Data>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderData {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderData(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        with(holder.binding) {
            name.text = dataList[position].name
            connect.text = dataList[position].connect
        }
    }

    override fun getItemCount() = dataList.size

}