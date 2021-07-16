package org.locer.`in`

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import org.locer.`in`.databinding.FragmentHomeBinding
import org.locer.`in`.recyclerView.ItemAdapter

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeBoundLayout: FragmentHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()

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

        val productAdapter = ItemAdapter()

        homeViewModel.products.observe(viewLifecycleOwner) {
            productAdapter.submitList(it)
        }

        homeBoundLayout.recyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

    }

}
