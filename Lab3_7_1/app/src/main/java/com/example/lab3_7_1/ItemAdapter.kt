package com.example.lab3_7_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3_7_1.databinding.ItemListBinding
class ItemAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // ViewHolder class sử dụng ViewBinding
    class ItemViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemViewHolder {
        // Sử dụng ViewBinding để inflate layout
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent,
            false)
        return ItemViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Gán dữ liệu vào các thành phần UI
        val item = itemList[position]
        holder.binding.tvName.text = item.name
        holder.binding.tvDescription.text = item.description
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
}
