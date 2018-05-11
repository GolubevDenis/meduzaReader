package com.golubev.denis.meduzareader.presentation.mvp.articles.list

import com.golubev.denis.meduzareader.domain.global.models.Article
import com.hannesdorfmann.mosby3.mvp.MvpView

interface ListArticlesView : MvpView {

    fun showNewArticles(list: List<Article>)
    fun showArticles(list: List<Article>)

    fun showLoadingProgress()
    fun showLoadingMoreProgress()

    fun hideLoadingProgress()
    fun hideLoadingMoreProgress()

    fun showErrorLoading()
}