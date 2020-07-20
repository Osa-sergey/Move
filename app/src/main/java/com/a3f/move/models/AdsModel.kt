package com.a3f.move.models

import androidx.recyclerview.widget.RecyclerView

data class AdsModel(override val type: Type = Type.ADS) : MultiListI {

    override fun getItemViewType(): Int = type.i

    override fun bind(viewHolder: RecyclerView.ViewHolder) {
        TODO("Not yet implemented")
    }
}