package com.a3f.move.models

import androidx.recyclerview.widget.RecyclerView

/**
 * Интерфейс для обобщения разного вида объектов в списке ReciclerView
 */
interface MultiListI {
    val type: Type
    val id: Int

    fun getItemViewType(): Int

    /**
     * Используется для binding данных в их графическое отображение
     */
    fun bind(viewHolder: RecyclerView.ViewHolder)
}