package com.a3f.move.datasource

import androidx.paging.PositionalDataSource
import com.a3f.move.models.MultiListI
import com.a3f.move.storage.OfferAndAdsStorage

class OfferAndAdsDataSource(var offerAndAdsStorage: OfferAndAdsStorage): PositionalDataSource<MultiListI>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<MultiListI>) {
        var list: MutableList<MultiListI> = offerAndAdsStorage.getOfferAndAds(params.requestedStartPosition, params.requestedLoadSize)
        callback.onResult(list, 0)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<MultiListI>) {
        var list: MutableList<MultiListI> = offerAndAdsStorage.getOfferAndAds(params.startPosition, params.loadSize)
        callback.onResult(list)
    }
}