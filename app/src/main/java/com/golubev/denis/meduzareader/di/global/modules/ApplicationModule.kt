package com.golubev.denis.meduzareader.di.global.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(
        context: Context
) {
    private val appContext: Context = context.applicationContext

    @Singleton
    @Provides
    fun provideApplicationContext() = appContext

}