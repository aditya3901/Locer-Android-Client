package org.locer.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.synnapps.carouselview.ImageListener
import org.locer.`in`.databinding.FragmentHistoryBinding
import org.locer.`in`.recyclerView.ParentAdapter
import org.locer.`in`.utils.SimilarItem
import org.locer.`in`.utils.SimilarItemCategory

/**
 * Authored by Ayush Shrivastava on 23/8/20
 */
class HistoryFragment : Fragment() {

    private lateinit var historyBoundLayout: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historyBoundLayout =
            DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)
        return  historyBoundLayout.root
    }
}
