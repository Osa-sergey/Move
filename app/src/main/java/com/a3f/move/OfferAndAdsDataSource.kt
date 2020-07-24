package com.a3f.move

import androidx.paging.PositionalDataSource
import com.a3f.move.models.MultiListI


/**
 * Класс прослойка между PagedList и данными из Storage
 */
class OfferAndAdsDataSource(var offerAndAdsStorage: OfferAndAdsStorage): PositionalDataSource<MultiListI>() {

    /**
     * Базовая загрузка данных при создании списка
     * Забирает 3*pageSize элементов
     */
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<MultiListI>) {
        var list: MutableList<MultiListI> = offerAndAdsStorage.getOfferAndAds(params.requestedStartPosition, params.requestedLoadSize)
        callback.onResult(list, 0)
    }

    /**
     * Подгрузка данных при приближении к концу загруженного списка
     * Забирает pageSize элементов
     */
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<MultiListI>) {
        var list: MutableList<MultiListI> = offerAndAdsStorage.getOfferAndAds(params.startPosition, params.loadSize)
        callback.onResult(list)
    }
}