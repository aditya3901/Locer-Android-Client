package org.locer.`in`.recyclerView

/**
This class is the adapter i.e. brain of how recycler view will look
 */
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.locer.`in`.databinding.ItemCategoryRvBinding
import org.locer.`in`.databinding.SimilarItemsBinding
import org.locer.`in`.utils.Category

class CategoryAdapter(private val categoryList: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>() {
    //This class is holding all the views that we want to display in a container of recycler view
    class ItemViewHolder(private val binding: ItemCategoryRvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.categoryName.text = item.name
            binding.categoryImage.setImageResource(item.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemCategoryRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = categoryList[position]
        holder.bind(item)
    }
}
