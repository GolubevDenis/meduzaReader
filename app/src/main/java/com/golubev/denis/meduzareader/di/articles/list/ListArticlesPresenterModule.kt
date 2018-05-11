package com.golubev.denis.meduzareader.di.articles.list

import com.golubev.denis.meduzareader.di.global.scopes.Presenter
import com.golubev.denis.meduzareader.presentation.mvp.articles.ArticlesActivityPresenter
import com.golubev.denis.meduzareader.presentation.mvp.articles.list.ListArticlesView
import com.golubev.denis.meduzareader.presentation.mvp.articles.list.ListFragmentPresenter
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import dagger.Module
import dagger.Provides

@Module
class ListArticlesPresenterModule {

    @Presenter
    @Provides
    fun provideListArticlesPresenter(activityPresenter: ListFragmentPresenter): MvpPresenter<ListArticlesView>
            = activityPresenter
}