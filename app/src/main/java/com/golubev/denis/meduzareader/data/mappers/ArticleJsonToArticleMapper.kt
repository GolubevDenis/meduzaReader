package com.golubev.denis.meduzareader.data.mappers

import com.golubev.denis.meduzareader.data.network.models.ArticleJsonModel
import com.golubev.denis.meduzareader.domain.global.models.Article
import java.util.*

class ArticleJsonToArticleMapper(
        val baseUrl: String
) : Mapper<ArticleJsonModel, Article> {

    override fun map(from: ArticleJsonModel) = Article(
            title = from.root.title,
            description = from.root.description,
            content = from.root.content.body,
            publishedAt = Date(from.root.publishedAt * 1000), // Умножаем на 1000,
            modifiedAt = Date(from.root.modifiedAt * 1000), // потому что сервер возвращает значение в секундах
            url = getFullUrl(from.root.url),
            imageUrl = getFullUrlOrNull(from.root.image?.smallUrl ?: from.root.image?.largeUrl),
            shareImageUrl = getFullUrl(from.root.shareImage),
            listImagesUrl =
                if(from.root.gallery != null)
                    List(from.root.gallery!!.size, {index -> getFullUrl(from.root.gallery!![index].smallUrl)})
                else null
    )

    private fun getFullUrl(url: String) = baseUrl + url.substring(1)
    private fun getFullUrlOrNull(url: String?)
            = if(url == null) null
            else baseUrl + url.substring(1)
}