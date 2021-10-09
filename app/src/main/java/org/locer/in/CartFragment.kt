package org.locer.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.locer.`in`.databinding.FragmentCartBinding
import org.locer.`in`.recyclerView.CartAdapter
import org.locer.`in`.recyclerView.CartItems

/**
 * Authored by Ayush Shrivastava on 23/8/20
 */
class CartFragment : Fragment() {
    private lateinit var cartBoundLayout: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cartBoundLayout =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        return cartBoundLayout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item1 = CartItems("Pepperoni Pizza", R.drawable.food2.toString(), 1, 4)
        val item2 = CartItems("Coca Cola", R.drawable.food1.toString(), 2, 8)
        val item3 = CartItems("Ice Cream", R.drawable.food2.toString(), 3, 12)
        val list = arrayListOf<CartItems>(item1, item2, item3, item1, item2, item3, item1, item2, item3)

        cartBoundLayout.recyclerView.apply {
            adapter = CartAdapter(list)
            layoutManager = LinearLayoutManager(context)
        }
    }
}
