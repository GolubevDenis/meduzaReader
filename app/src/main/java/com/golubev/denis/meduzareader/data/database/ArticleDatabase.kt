package com.golubev.denis.meduzareader.data.database

import com.golubev.denis.meduzareader.data.database.models.ArticleDatabaseModel
import io.reactivex.Completable
import io.reactivex.Single

interface ArticleDatabase {

    fun getArticle(articleUrl: String): Single<ArticleDatabaseModel>

    fun addArticle(articleDatabase: ArticleDatabaseModel): Completable

    fun getListArticles(offset: Int, count: Int): Single<List<ArticleDatabaseModel>>
}