package com.a3f.move.di.components

import com.a3f.move.di.modules.OfferAndAdsAdapterModel
import com.a3f.move.fragments.others.ListMapSearchFragment
import dagger.Component

@Component(modules = [OfferAndAdsAdapterModel::class])
interface PagedListComponent {

    fun inject(listMapSearchFragment: ListMapSearchFragment) {}
}