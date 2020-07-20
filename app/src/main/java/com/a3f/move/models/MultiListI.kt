package com.a3f.move.models

import androidx.recyclerview.widget.RecyclerView

interface MultiListI {
    val type: Type
    val id: Int

    fun getItemViewType(): Int
    fun bind(viewHolder: RecyclerView.ViewHolder)
}