package com.golubev.denis.meduzareader.presentation.mvp.articles.list

import android.util.Log
import com.golubev.denis.meduzareader.domain.articles.list.ListArticlesInteractor
import com.golubev.denis.meduzareader.domain.global.models.Article
import com.golubev.denis.meduzareader.logTag
import com.golubev.denis.meduzareader.presentation.mvp.global.scheduler.SchedulersProvider
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject

class ListFragmentPresenter @Inject constructor(
        private val interactor: ListArticlesInteractor,
        private val scheduler: SchedulersProvider
) : MvpBasePresenter<ListArticlesView>(){

    private var listArticles = arrayListOf<Article>()
    private var currentPage = 0

    override fun attachView(view: ListArticlesView) {
        super.attachView(view)
        view.showLoadingProgress()
    }

    fun firstLoadArticles() {
        currentPage = 0
        // Если уже есть загруженные новости, то покажем их
        if(listArticles.size > 0){
            ifViewAttached {
                it.showArticles(listArticles)
                it.hideLoadingProgress()
            }
        }
        load().subscribe({
                    ifViewAttached {
                        it.hideLoadingProgress()
                    }
                    showArticles(it)
                }, this::onListLoadingError)
    }

    fun refreshArticles() {
        showArticles(emptyList())
        firstLoadArticles()
    }

    fun loadMoreArticles() {
        currentPage++
        load().subscribe({
                    ifViewAttached {
                        it.hideLoadingMoreProgress()
                    }
                    showNewArticles(it)
                }, this::onListLoadingError)
    }

    private fun onListLoadingError(throwable: Throwable){
        throwable.printStackTrace()
        ifViewAttached {
            if(isFirstLoading()){
                it.hideLoadingProgress()
            }else{
                it.hideLoadingMoreProgress()
            }
            it.showErrorLoading()
        }
    }

    private fun showArticles(list: List<Article>){
        listArticles.clear()
        listArticles.addAll(list)
        ifViewAttached { it.showArticles(list) }
    }

    private fun showNewArticles(list: List<Article>){
        listArticles.addAll(list)
        ifViewAttached { it.showNewArticles(list) }
    }

    private fun load() = interactor.getListArticles(currentPage)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())

    private fun isFirstLoading(): Boolean = currentPage == 0
}