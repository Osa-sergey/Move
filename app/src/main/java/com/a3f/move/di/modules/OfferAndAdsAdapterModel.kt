package com.a3f.move.di.modules

import androidx.paging.PagedList
import com.a3f.move.adapters.OfferAndAdsAdapter
import com.a3f.move.diffutils.OfferAndAdsDiffUtilCallback
import com.a3f.move.models.MultiListI
import com.a3f.move.pagedlist.MainThreadExecutor
import com.a3f.move.pagedlist.OfferAndAdsDataSource
import com.a3f.move.pagedlist.OfferAndAdsStorage
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executors

@Module
class OfferAndAdsAdapterModel(private val pageSize: Int, private val placeholder: Boolean = false) {

    @Provides
    fun getOfferAndAdsStorage(): OfferAndAdsStorage =
        OfferAndAdsStorage()

    @Provides
    fun getOfferAndAdsDataSource(offerAndAdsStorage: OfferAndAdsStorage): OfferAndAdsDataSource =
        OfferAndAdsDataSource(offerAndAdsStorage)

    @Provides
    fun getConfig(): PagedList.Config =
        PagedList.Config.Builder()
            .setEnablePlaceholders(placeholder)
            .setPageSize(pageSize)
            .build()

    @Provides
    fun getPagedList(dataSource: OfferAndAdsDataSource, config: PagedList.Config,
                     mainThreadExecutor: MainThreadExecutor
    ): PagedList<MultiListI> =
        PagedList.Builder(dataSource, config)
            .setNotifyExecutor(mainThreadExecutor)
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .build()

    @Provides
    fun getDiffUtilCallback(): OfferAndAdsDiffUtilCallback = OfferAndAdsDiffUtilCallback()

    @Provides
    fun getMainThreadExecutor(): MainThreadExecutor =
        MainThreadExecutor()

    @Provides
    fun getOfferAndAdsAdapter(diffUtilCallback: OfferAndAdsDiffUtilCallback,
    pagedList: PagedList<MultiListI>): OfferAndAdsAdapter {
        val adapter = OfferAndAdsAdapter(diffUtilCallback)
        adapter.submitList(pagedList)
        return adapter
    }
}