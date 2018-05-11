package com.golubev.denis.meduzareader.domain.articles.list

import com.golubev.denis.meduzareader.domain.global.repository.ArticlesRepository
import javax.inject.Inject

class ListArticlesInteractor @Inject constructor(
        val articlesRepository: ArticlesRepository
){
    fun getListArticles(page: Int) = articlesRepository.getListArticles(page)
}