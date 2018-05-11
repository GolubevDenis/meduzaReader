package com.golubev.denis.meduzareader.domain.global.repository

import com.golubev.denis.meduzareader.domain.global.models.Article
import io.reactivex.Observable
import io.reactivex.Single

interface ArticlesRepository {

    fun getListArticles(page: Int): Single<List<Article>>

    fun getArticle(articleUrl: String): Single<Article>
}