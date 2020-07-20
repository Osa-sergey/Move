package com.a3f.move.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.a3f.move.models.MultiListI

class OfferAndAdsAdapter(callback: DiffUtil.ItemCallback<MultiListI>) : PagedListAdapter<MultiListI, RecyclerView.ViewHolder>(callback) {

    override fun getItemViewType(pos: Int): Int = getItem(pos)!!.getItemViewType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolderFactory.create(parent, viewType)!!

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) = getItem(pos)!!.bind(holder)

}