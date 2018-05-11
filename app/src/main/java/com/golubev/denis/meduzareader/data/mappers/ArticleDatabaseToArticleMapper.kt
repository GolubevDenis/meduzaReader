package com.golubev.denis.meduzareader.data.mappers

import android.util.Log
import com.golubev.denis.meduzareader.data.database.models.ArticleDatabaseModel
import com.golubev.denis.meduzareader.domain.global.models.Article
import com.golubev.denis.meduzareader.logTag
import java.util.*

class ArticleDatabaseToArticleMapper : Mapper<ArticleDatabaseModel, Article>{

    override fun map(from: ArticleDatabaseModel): Article {
        return Article(
                url = from.url!!,
                title = from.title!!,
                description = from.description!!,
                content = from.content,
                publishedAt = Date(from.publishedAt!!),
                modifiedAt = Date(from.modifiedAt!!),
                imageUrl = from.imageUrl,
                listImagesUrl = from.listImagesUrl?.map { it.url!! },
                shareImageUrl = from.shareImageUrl!!
        )
    }

}