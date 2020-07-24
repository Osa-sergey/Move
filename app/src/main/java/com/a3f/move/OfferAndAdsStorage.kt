package com.a3f.move

import com.a3f.move.models.AdsModel
import com.a3f.move.models.MultiListI
import com.a3f.move.models.OfferModel


class OfferAndAdsStorage() {
    fun getOfferAndAds(start: Int, size: Int): MutableList<MultiListI> {
        var list: MutableList<MultiListI> = mutableListOf()
        for (i in start..start+size){
            if (i%2 == 0)
                list.add(AdsModel(id = i, str = "Реклама №$i"))
            else
                list.add(OfferModel(id = i, str = "Предложение №$i"))
        }
        return list
    }
}