package com.golubev.denis.meduzareader.data.mappers

import com.golubev.denis.meduzareader.data.database.models.ArticleDatabaseModel
import com.golubev.denis.meduzareader.data.database.models.ImageForListDB
import com.golubev.denis.meduzareader.domain.global.models.Article
import io.realm.RealmList

class ArticleToArticleDatabaseMapper : Mapper<Article, ArticleDatabaseModel>{

    override fun map(from: Article): ArticleDatabaseModel {
        val article = ArticleDatabaseModel()

        article.url = from.url
        article.title = from.title
        article.description = from.description
        article.content = from.content
        article.publishedAt = from.publishedAt.time
        article.modifiedAt = from.modifiedAt.time
        article.imageUrl = from.imageUrl

        val realmList = RealmList<ImageForListDB>()
        from.listImagesUrl?.map {
            val image = ImageForListDB()
            image.url = it
            realmList.add(image)
            image
        }
        article.listImagesUrl = realmList

        article.shareImageUrl = from.shareImageUrl

        return article
    }

}