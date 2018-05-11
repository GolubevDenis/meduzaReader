package com.golubev.denis.meduzareader.data.database

import android.util.Log
import com.golubev.denis.meduzareader.data.database.models.ArticleDatabaseModel
import com.golubev.denis.meduzareader.logTag
import io.reactivex.Completable
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class RealmArticleDatabase @Inject constructor(
        private val configuration: RealmConfiguration
) : ArticleDatabase {

    private fun getAllArticleModels(offset: Int, count: Int): List<ArticleDatabaseModel> {
        val realm: Realm = Realm.getInstance(configuration)
        val query = realm.where(ArticleDatabaseModel::class.java)
        val items = query.findAllAsync()
        val results = realm.copyFromRealm(items)
        results.sortByDescending { it.publishedAt }
        var endOffset = offset + count
        var startOffset = offset
        val size = results.size
        if(endOffset >= size) endOffset = size - 1
        if(startOffset >= size) startOffset = size - 1
        if(endOffset < startOffset) endOffset = startOffset
        realm.close()
        return results.subList(startOffset, endOffset)
    }

    private fun getArticleModel(article: String): ArticleDatabaseModel {
        val realm: Realm = Realm.getInstance(configuration)
        val query = realm.where(ArticleDatabaseModel::class.java)
        query.equalTo(ArticleDatabaseModel.URL, article)
        val result = query.findFirst()
        realm.close()
        return result!!
    }

    override fun getListArticles(offset: Int, count: Int): Single<List<ArticleDatabaseModel>> {
        return Single.just(getAllArticleModels(offset, count))
    }

    override fun getArticle(articleUrl: String): Single<ArticleDatabaseModel> {
        return Single.just(getArticleModel(articleUrl))
    }

    override fun addArticle(articleDatabase: ArticleDatabaseModel): Completable {
        val realm: Realm = Realm.getInstance(RealmConfiguration.Builder().build())
        return Completable.fromRunnable {
            realm.copyToRealmOrUpdate(articleDatabase)
            realm.commitTransaction()
        }
                .doOnSubscribe { realm.beginTransaction() }
                .doOnError { realm.cancelTransaction() }
                .doFinally { realm.close() }
    }
}