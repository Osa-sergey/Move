package com.a3f.move.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.a3f.move.models.MultiListI

/**
 * Адаптер для списка с пагинацией
 */
class OfferAndAdsAdapter(callback: DiffUtil.ItemCallback<MultiListI>) : PagedListAdapter<MultiListI, RecyclerView.ViewHolder>(callback) {

    /**
     * Возвращает тип View в зависимости от того является view рекламным постом или предложением
     */
    override fun getItemViewType(pos: Int): Int = getItem(pos)!!.getItemViewType()

    /**
     * С помощью фабрики возвращаем нужного типа viewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolderFactory.create(parent, viewType)!!

    /**
     * Привязываем данные к viewHolder при переиспользовании
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) = getItem(pos)!!.bind(holder)

}