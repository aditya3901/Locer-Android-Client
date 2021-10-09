package org.locer.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.synnapps.carouselview.ImageListener
import org.locer.`in`.databinding.FragmentHomeBinding
import org.locer.`in`.recyclerView.CategoryAdapter
import org.locer.`in`.recyclerView.ShopListAdapter
import org.locer.`in`.utils.Category

/**
 * Authored by Ayush Shrivastava on 23/8/20
 */
class HomeFragment : Fragment() {

    private lateinit var homeBoundLayout: FragmentHomeBinding
    var sampleImages = ArrayList<Int>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        homeBoundLayout =
                DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return homeBoundLayout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = Category("Grocery", R.drawable.food1)
        val list = arrayListOf(item, item, item, item, item, item)
        homeBoundLayout.recyclerView.apply {
            adapter = CategoryAdapter(list)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        sampleImages = arrayListOf(R.drawable.food1, R.drawable.food2, R.drawable.fastfood)
        homeBoundLayout.carouselView.setImageListener(imageListener)
        homeBoundLayout.carouselView.pageCount = sampleImages.size

        val item1 = Category("Spencer's", R.drawable.food2)
        val item2 = Category("Walmart", R.drawable.food1)
        val item3 = Category("7-Eleven", R.drawable.food2)
        val item4 = Category("Big Bazaar", R.drawable.food1)
        val shopList = arrayListOf(item1, item2, item3, item4, item1, item2, item3, item4, item1, item2, item3, item4)

        homeBoundLayout.shopRv.apply {
            adapter = ShopListAdapter(shopList)
            layoutManager = LinearLayoutManager(context)
        }
    }
    private val imageListener = ImageListener { position, imageView ->
        imageView.setImageResource(sampleImages[position])
    }

}