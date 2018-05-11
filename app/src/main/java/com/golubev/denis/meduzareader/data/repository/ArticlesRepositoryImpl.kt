package com.golubev.denis.meduzareader.data.repository

import com.golubev.denis.meduzareader.data.android.internetconnection.NetworkConnectionManager
import com.golubev.denis.meduzareader.data.database.ArticleDatabase
import com.golubev.denis.meduzareader.data.database.models.ArticleDatabaseModel
import com.golubev.denis.meduzareader.data.mappers.Mapper
import com.golubev.denis.meduzareader.data.network.MeduzaApiService
import com.golubev.denis.meduzareader.data.network.models.ArticleJsonModel
import com.golubev.denis.meduzareader.domain.global.models.Article
import com.golubev.denis.meduzareader.domain.global.repository.ArticlesRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(
        private val api: MeduzaApiService,
        private val database: ArticleDatabase,
        private val networkToArticleMapper: Mapper<ArticleJsonModel, Article>,
        private val databaseToArticleMapper: Mapper<ArticleDatabaseModel, Article>,
        private val articleToDatabaseMapper: Mapper<Article, ArticleDatabaseModel>,
        private val networkConnectionManager: NetworkConnectionManager
) : ArticlesRepository {

    companion object {
        const val COUNT_NEWS = 24
    }

    override fun getArticle(articleUrl: String): Single<Article> {
        return if(networkConnectionManager.haveNetworkConnection()){
            api.getArticle(articleUrl)
                    .flatMap {Single.just(networkToArticleMapper.map(it))}
                    .doOnSuccess {
                        database.addArticle(articleToDatabaseMapper.map(it)).subscribe()
                    }
        }else{
            database.getArticle(articleUrl).flatMap {
                Single.just(databaseToArticleMapper.map(it))
            }
        }
    }

    override fun getListArticles(page: Int): Single<List<Article>> {
        return if(networkConnectionManager.haveNetworkConnection()){
            api.getListArticles(page, COUNT_NEWS)
                    .toObservable()
                    .flatMap { Observable.fromIterable(it.collection)}
                    .flatMap { getArticle(it).toObservable() }
                    .sorted { o1, o2 -> if(o1.publishedAt > o2.publishedAt) -1 else 1}
                    .toList()
        }else{
            database.getListArticles(page * COUNT_NEWS, COUNT_NEWS)
                    .map { databaseToArticleMapper.map(it) }
        }
    }
}