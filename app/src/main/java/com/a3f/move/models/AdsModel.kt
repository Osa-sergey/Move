package com.a3f.move.models

import androidx.recyclerview.widget.RecyclerView
import com.a3f.move.adapters.ViewHolderFactory

data class AdsModel(override val id: Int, override val type: Type = Type.ADS, val str: String) : MultiListI {

    override fun getItemViewType(): Int = type.i

    override fun bind(viewHolder: RecyclerView.ViewHolder) {
        val view = viewHolder as ViewHolderFactory.AdsViewHolder
        view.text.text = str
        //  TODO"Добавить поля"
    }
}