package com.golubev.denis.meduzareader.di.global

import android.databinding.DataBindingComponent
import com.golubev.denis.meduzareader.di.global.modules.BindingModule
import com.golubev.denis.meduzareader.di.global.scopes.DataBinding
import com.golubev.denis.meduzareader.presentation.ui.global.binding.DataFormatBindingAdapter
import com.golubev.denis.meduzareader.presentation.ui.global.binding.ImageUrlBindingAdapter
import dagger.Component

@DataBinding
@Component(dependencies = [ApplicationComponent::class], modules = [BindingModule::class])
interface BindingComponent : DataBindingComponent {

    override fun getImageUrlBindingAdapter(): ImageUrlBindingAdapter
    override fun getDataFormatBindingAdapter(): DataFormatBindingAdapter
}