package com.golubev.denis.meduzareader.data.network

import com.golubev.denis.meduzareader.data.network.models.ArticleJsonModel
import com.golubev.denis.meduzareader.data.network.models.ListArticlesResponse
import com.golubev.denis.meduzareader.data.network.models.rss.Rss
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MeduzaApiService {

    @GET("rss/all")
    fun getAll(): Single<Rss>

    @GET("api/v3/search?chrono=news&locale=ru")
    fun getListArticles(@Query("page") page: Int, @Query("per_page") perPage: Int): Single<ListArticlesResponse>

    @GET("api/v3/{article}")
    fun getArticle(@Path("article") article: String): Single<ArticleJsonModel>
}