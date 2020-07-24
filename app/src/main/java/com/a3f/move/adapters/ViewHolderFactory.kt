package com.a3f.move.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a3f.move.R
import com.a3f.move.models.Type

/**
 * Шаблон фабрика для создания viewHolder
 */
class ViewHolderFactory {

    /**
     * Класс viewHolder для типа элемента ркеламное предложение
     * Методы bind для viewHolder в
     * @see com.a3f.move.models.AdsModel
     */
    class AdsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text = itemView.findViewById(R.id.text) as TextView
        //TODO дописать поля
    }

    /**
     * Класс viewHolder для типа элемента предложение
     * Методы bind для viewHolder в
     * @see com.a3f.move.models.OfferModel
     */
    class OfferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text = itemView.findViewById(R.id.text) as TextView
        //TODO дописать поля
    }

    /**
     * Метод для создания viewHolder в зависимости от типа view
     */
    companion object{
        fun create(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
            when(viewType){
                Type.ADS.i -> {
                    val adsView = LayoutInflater.from(parent.context).inflate(R.layout.view_ads_simple_item, parent, false)
                    return AdsViewHolder(adsView)
                }
                Type.OFFER.i -> {
                    val offerView = LayoutInflater.from(parent.context).inflate(R.layout.view_offer_simple_item, parent, false)
                    return OfferViewHolder(offerView)
                }
                else -> return null
            }
        }
    }
}