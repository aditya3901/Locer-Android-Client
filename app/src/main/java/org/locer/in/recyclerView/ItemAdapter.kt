package org.locer.`in`.recyclerView

/**
This class is the adapter i.e. brain of how recycler view will look
 */
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.locer.`in`.databinding.ItemHomeRvBinding
import org.locer.`in`.utils.PopularFood

class ItemAdapter :
    ListAdapter<PopularFood, ItemAdapter.ItemViewHolder>(POPULAR_FOOD_COMPARATOR) {

    companion object {
        private val POPULAR_FOOD_COMPARATOR = object: DiffUtil.ItemCallback<PopularFood>() {
            override fun areItemsTheSame(oldItem: PopularFood, newItem: PopularFood): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: PopularFood, newItem: PopularFood): Boolean {
                return oldItem == newItem
            }
        }
    }

    //This class is holding all the views that we want to display in a container of recycler view
    class ItemViewHolder(private val binding: ItemHomeRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PopularFood) {
            binding.apply {
                popularItemName.text = item.title
                popularItemDescription.text = item.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemHomeRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
