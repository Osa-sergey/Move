package com.a3f.move.models

import androidx.recyclerview.widget.RecyclerView
import com.a3f.move.adapters.ViewHolderFactory

/**
 * Модель элемента предложения
 */
data class OfferModel(override val id: Int, override val type: Type = Type.OFFER, val str: String) :
    MultiListI {

    override fun getItemViewType(): Int = type.i

    override fun bind(viewHolder: RecyclerView.ViewHolder) {
        var view = viewHolder as ViewHolderFactory.OfferViewHolder
        view.text.text = str
        // TODO "Добавить поля"
    }
}