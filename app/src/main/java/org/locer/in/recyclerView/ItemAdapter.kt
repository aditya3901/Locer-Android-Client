package org.locer.`in`.recyclerView

/**
This class is the adapter i.e. brain of how recycler view will look
 */
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.locer.`in`.databinding.ItemHomeRvBinding
import org.locer.`in`.utils.PopularFood

class ItemAdapter(private val popularFoodList: List<PopularFood>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    //This class is holding all the views that we want to display in a container of recycler view
    class ItemViewHolder(private val binding: ItemHomeRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PopularFood) {
            binding.popularItemName.text = item.name
            binding.popularItemDescription.text = item.description
            binding.popularItemImage.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemHomeRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return popularFoodList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = popularFoodList[position]
        holder.bind(currentItem)
    }
}
