package com.a3f.move.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.a3f.move.models.AdsModel
import com.a3f.move.models.MultiListI
import com.a3f.move.models.OfferModel
import com.a3f.move.models.Type

/**
 * Класс необходимый для оптимального алгоритма перерисовки элементов при изменении в списке
 * отображаемых объектов RecyclerView
 */
class OfferAndAdsDiffUtilCallback() : DiffUtil.ItemCallback<MultiListI>() {

    /**
     * Первоначальная проверка на то, что данные элементы являются разными версиями одного и
     * того же элемента списка
     **/
    override fun areItemsTheSame(oldItem: MultiListI, newItem: MultiListI): Boolean =
        oldItem.type.i == newItem.type.i && oldItem.id == newItem.id

    /**
     * Детальнон сравнение внутреннего контента элементов
     * вызывается после уданого исполнения areItemsTheSame
     */
    override fun areContentsTheSame(oldItem: MultiListI, newItem: MultiListI): Boolean {
        when(oldItem.type.i){
            Type.ADS.i -> {
                //TODO учесть поля
                val old = oldItem as AdsModel
                val new = newItem as AdsModel
                return old.str.equals(new.str)
            }
            Type.OFFER.i -> {
                //TODO учесть поля
                val old = oldItem as OfferModel
                val new = newItem as OfferModel
                return old.str.equals(new.str)
            }
            else -> return false
        }
    }
}