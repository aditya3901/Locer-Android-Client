package org.locer.`in`.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.locer.`in`.databinding.CartRecyclerItemBinding

class CartAdapter(private val items: ArrayList<CartItems>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    class CartViewHolder(private val binding: CartRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: CartItems){
            binding.itemName.text = item.itemName
            binding.itemCount.text = item.itemCount.toString()
            binding.itemPrice.text = item.itemPrice.toString()
            binding.itemImage.setImageResource(item.itemImage.toInt())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val current = items[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}