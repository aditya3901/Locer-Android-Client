package org.locer.`in`.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.locer.`in`.databinding.ItemParentRvBinding
import org.locer.`in`.utils.SimilarItemCategory

class ParentAdapter(private val list: ArrayList<SimilarItemCategory>): RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemParentRvBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SimilarItemCategory){
            binding.categoryTitle.text = item.title
            binding.childRv.apply {
                adapter = SimilarItemsAdapter(item.categoryItem)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemParentRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = list[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}