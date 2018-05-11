package com.golubev.denis.meduzareader.di.global.modules

import android.content.Context
import com.golubev.denis.meduzareader.data.android.internetconnection.NetworkConnectionManager
import com.golubev.denis.meduzareader.data.android.internetconnection.NetworkConnectionManagerImpl
import com.golubev.denis.meduzareader.data.android.resources.AndroidResourceManager
import com.golubev.denis.meduzareader.data.android.resources.ResourceManager
import com.golubev.denis.meduzareader.data.database.ArticleDatabase
import com.golubev.denis.meduzareader.data.database.RealmArticleDatabase
import com.golubev.denis.meduzareader.data.network.MeduzaApiService
import com.golubev.denis.meduzareader.data.repository.ArticlesRepositoryImpl
import com.golubev.denis.meduzareader.di.global.qualifiers.MeduzaUrl
import com.golubev.denis.meduzareader.domain.global.repository.ArticlesRepository
import com.golubev.denis.meduzareader.presentation.mvp.global.scheduler.SchedulersProvider
import com.golubev.denis.meduzareader.presentation.mvp.global.scheduler.SchedulersProviderImpl
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.io.File
import javax.inject.Singleton

@Module(includes = [MappersModule::class])
class DataModule {

    @Singleton
    @Provides
    fun provideArticlesDatabase(database: RealmArticleDatabase): ArticleDatabase
        = database

    @Singleton
    @Provides
    fun provideRealmConfiguration(context: Context): RealmConfiguration{
        Realm.init(context)
        return RealmConfiguration.Builder().build()
    }

    @Singleton
    @Provides
    fun provideArticlesApi(retrofit: Retrofit): MeduzaApiService
            = retrofit.create(MeduzaApiService::class.java)

    @Singleton
    @Provides
    fun provideArticlesRepository(repository: ArticlesRepositoryImpl): ArticlesRepository
            = repository

    @Singleton
    @Provides
    fun provideResourcesManager(context: Context): ResourceManager
            = AndroidResourceManager(context)

    @Singleton
    @Provides
    fun provideSchedulersProvider(provider: SchedulersProviderImpl): SchedulersProvider
        = provider

    @MeduzaUrl
    @Provides
    fun provideMeduzaUrl() = "https://meduza.io/"
}