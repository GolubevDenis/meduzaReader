package com.golubev.denis.meduzareader.di.global

import com.golubev.denis.meduzareader.di.articles.ArticlesActivityPresenterComponent
import com.golubev.denis.meduzareader.di.articles.list.ListArticlesComponent
import com.golubev.denis.meduzareader.di.articles.list.ListArticlesViewModule
import com.golubev.denis.meduzareader.di.global.modules.ApplicationModule
import com.golubev.denis.meduzareader.di.global.modules.DataModule
import com.golubev.denis.meduzareader.di.global.modules.NetworkModule
import com.golubev.denis.meduzareader.di.global.modules.UtilsModule
import com.squareup.picasso.Picasso
import dagger.Component
import java.text.DateFormat
import java.text.SimpleDateFormat
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class, NetworkModule::class, UtilsModule::class])
interface ApplicationComponent {

    fun getArticlesActivityComponent(): ArticlesActivityPresenterComponent
    fun getArticlesListComponent(module: ListArticlesViewModule): ListArticlesComponent

    fun getPicasso(): Picasso
    fun getDataFormat(): DateFormat
}