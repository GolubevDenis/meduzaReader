package com.golubev.denis.meduzareader.di.global.modules

import android.content.Context
import android.os.Build
import dagger.Module
import dagger.Provides
import java.text.DateFormat
import java.text.SimpleDateFormat
import javax.inject.Singleton

@Module
class UtilsModule {

    @Provides
    @Singleton
    fun provideNewsSimpleDateFormat(context: Context) : DateFormat
        = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                SimpleDateFormat("h:mm a dd MMMM", context.resources.configuration.locales[0])
         else
                SimpleDateFormat("h:mm a dd MMMM", context.resources.configuration.locale)

}