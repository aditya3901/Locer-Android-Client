package org.locer.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.locer.`in`.databinding.FragmentHomeBinding
import org.locer.`in`.recyclerView.ItemAdapter
import org.locer.`in`.utils.PopularFood

class HomeFragment : Fragment() {

    private lateinit var homeBoundLayout: FragmentHomeBinding

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

        val item = PopularFood("Chowmin", "Enjoy the best chowmin in town with superfast", R.drawable.demo_image)
        val list = arrayListOf(item, item, item, item, item)
        homeBoundLayout.recyclerView.apply {
            adapter = ItemAdapter(list)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

    }

}