package org.locer.`in`.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.locer.`in`.databinding.ItemShopRvBinding
import org.locer.`in`.utils.Category

class ShopListAdapter(private val shopList: List<Category>): RecyclerView.Adapter<ShopListAdapter.ShopViewHolder>() {
    class ShopViewHolder(private val binding: ItemShopRvBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.shopName.text = item.name
            binding.shopImage.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding = ItemShopRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val item = shopList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

}