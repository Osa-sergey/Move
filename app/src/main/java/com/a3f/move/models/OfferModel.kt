package com.a3f.move.models

import androidx.recyclerview.widget.RecyclerView

data class OfferModel(override val type: Type = Type.OFFER) : MultiListI {

    override fun getItemViewType(): Int = type.i

    override fun bind(viewHolder: RecyclerView.ViewHolder) {
        TODO("Not yet implemented")
    }
}