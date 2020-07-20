package com.a3f.move.fragments.bottom.others

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.a3f.move.R
import com.a3f.move.adapters.OfferAndAdsAdapter
import com.a3f.move.datasource.OfferAndAdsDataSource
import com.a3f.move.diffutils.OfferAndAdsDiffUtilCallback
import com.a3f.move.executor.MainThreadExecutor
import com.a3f.move.models.MultiListI
import com.a3f.move.storage.OfferAndAdsStorage
import kotlinx.android.synthetic.main.fragment_list_map_search.*
import java.util.concurrent.Executors

class listMapSearchFragment: Fragment(R.layout.fragment_list_map_search) {

    lateinit var adapter: OfferAndAdsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        listMapSearch.layoutManager = LinearLayoutManager(context)
        var dataSource: OfferAndAdsDataSource = OfferAndAdsDataSource(OfferAndAdsStorage())
        var config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20)
            .build()

        var pagedList: PagedList<MultiListI> = PagedList.Builder(dataSource, config)
            .setNotifyExecutor(MainThreadExecutor())
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .build()

        var diffUtilCallback = OfferAndAdsDiffUtilCallback()
        adapter = OfferAndAdsAdapter(diffUtilCallback)
        adapter.submitList(pagedList)
        listMapSearch.adapter = adapter
    }
}