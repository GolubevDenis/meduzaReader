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
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(@MeduzaUrl meduzaUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(meduzaUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideNetworkConnectionManager(manager: NetworkConnectionManagerImpl): NetworkConnectionManager
        = manager

    @Provides
    @Singleton
    fun provideCache(cacheFile: File): Cache {
        return Cache(cacheFile, 512 * 1024 * 1024) //512 MB for cache
    }

    @Provides
    @Singleton
    fun provideCacheFile(context: Context): File {
        return File(context.cacheDir, "okhttp_cache")
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(cache)
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpDownloader(client: OkHttpClient)
            = OkHttp3Downloader(client)

    @Provides
    @Singleton
    fun providePicasso(context: Context, downloader: OkHttp3Downloader): Picasso
        = Picasso.Builder(context)
                .downloader(downloader)
                .indicatorsEnabled(true)
                .build()
}