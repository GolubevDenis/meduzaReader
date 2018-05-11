package com.golubev.denis.meduzareader.di.global.modules

import com.golubev.denis.meduzareader.data.database.models.ArticleDatabaseModel
import com.golubev.denis.meduzareader.data.mappers.ArticleDatabaseToArticleMapper
import com.golubev.denis.meduzareader.data.mappers.ArticleJsonToArticleMapper
import com.golubev.denis.meduzareader.data.mappers.ArticleToArticleDatabaseMapper
import com.golubev.denis.meduzareader.data.mappers.Mapper
import com.golubev.denis.meduzareader.data.network.models.ArticleJsonModel
import com.golubev.denis.meduzareader.di.global.qualifiers.MeduzaUrl
import com.golubev.denis.meduzareader.domain.global.models.Article
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MappersModule {

    @Singleton
    @Provides
    fun provideArticleDatabaseToArticleMapper(): Mapper<ArticleDatabaseModel, Article>
            = ArticleDatabaseToArticleMapper()

    @Singleton
    @Provides
    fun provideArticleJsonToArticleMapper(@MeduzaUrl meduzaUrl: String): Mapper<ArticleJsonModel, Article>
            = ArticleJsonToArticleMapper(meduzaUrl)

    @Singleton
    @Provides
    fun provideArticleToArticleDatabaseMapper(): Mapper<Article, ArticleDatabaseModel>
            = ArticleToArticleDatabaseMapper()

}