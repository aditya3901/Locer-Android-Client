package org.locer.`in`.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.locer.`in`.databinding.SimilarItemsBinding
import org.locer.`in`.utils.SimilarItem

class SimilarItemsAdapter(private val list: ArrayList<SimilarItem>): RecyclerView.Adapter<SimilarItemsAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val binding: SimilarItemsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SimilarItem){
            binding.itemName.text = item.name
            binding.itemPrice.text = "$${item.price}"
            binding.itemImage.setImageResource(item.image.toInt())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = SimilarItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = list[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}