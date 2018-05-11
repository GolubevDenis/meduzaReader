package com.golubev.denis.meduzareader.di.global.modules

import com.golubev.denis.meduzareader.di.global.scopes.DataBinding
import com.golubev.denis.meduzareader.presentation.ui.global.binding.DataFormatBindingAdapter
import com.golubev.denis.meduzareader.presentation.ui.global.binding.ImageUrlBindingAdapter
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import java.text.DateFormat

@Module
class BindingModule {

    @Provides
    @DataBinding
    fun provideImageYrlBindingAdapter(picasso: Picasso)
        = ImageUrlBindingAdapter(picasso)

    @Provides
    @DataBinding
    fun provideDataFormatBindingAdapter(dataFormat: DateFormat)
        = DataFormatBindingAdapter(dataFormat)
}