package com.golubev.denis.meduzareader.di.articles

import com.golubev.denis.meduzareader.di.global.ApplicationComponent
import com.golubev.denis.meduzareader.di.global.scopes.Presenter
import com.golubev.denis.meduzareader.presentation.mvp.articles.ArticlesActivityPresenter
import dagger.Component
import dagger.Subcomponent

@Presenter
@Subcomponent(modules = [ArticlesActivityPresenterModule::class])
interface ArticlesActivityPresenterComponent {

    fun getPresenter() : ArticlesActivityPresenter
}