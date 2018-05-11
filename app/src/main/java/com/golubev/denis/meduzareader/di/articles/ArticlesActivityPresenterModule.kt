package com.golubev.denis.meduzareader.di.articles

import com.golubev.denis.meduzareader.di.global.scopes.Presenter
import com.golubev.denis.meduzareader.presentation.mvp.articles.ArticlesActivityPresenter
import dagger.Module
import dagger.Provides

@Module
class ArticlesActivityPresenterModule {

    @Presenter
    @Provides
    fun provideListActivityPresenter() = ArticlesActivityPresenter()
}