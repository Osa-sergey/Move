package com.a3f.move.fragments.others

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.a3f.move.App
import com.a3f.move.R
import com.a3f.move.adapters.OfferAndAdsAdapter
import kotlinx.android.synthetic.main.fragment_list_map_search.*
import javax.inject.Inject

class ListMapSearchFragment : Fragment(R.layout.fragment_list_map_search) {

    @Inject
    lateinit var adapter: OfferAndAdsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        App.pagedListComponent.inject(this)
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        listMapSearch.layoutManager = LinearLayoutManager(context)
        listMapSearch.adapter = adapter
    }
}