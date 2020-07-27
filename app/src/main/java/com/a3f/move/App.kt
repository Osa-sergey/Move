package com.a3f.move

import android.app.Application
import com.a3f.move.di.components.DaggerPagedListComponent
import com.a3f.move.di.components.PagedListComponent
import com.a3f.move.di.modules.OfferAndAdsAdapterModel

class App: Application() {
    companion object{
        lateinit var pagedListComponent: PagedListComponent
    }

    override fun onCreate() {
        super.onCreate()
        pagedListComponent = buildComponent()
    }

    private fun buildComponent(): PagedListComponent =
        DaggerPagedListComponent.builder()
            .offerAndAdsAdapterModel(OfferAndAdsAdapterModel(20))
            .build()
}