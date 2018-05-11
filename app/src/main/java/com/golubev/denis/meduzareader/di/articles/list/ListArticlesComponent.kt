package com.golubev.denis.meduzareader.di.articles.list

import com.golubev.denis.meduzareader.di.global.scopes.Presenter
import com.golubev.denis.meduzareader.presentation.mvp.articles.list.ListFragmentPresenter
import com.golubev.denis.meduzareader.presentation.ui.articles.list.ListArticlesFragment
import dagger.Subcomponent

@Presenter
@Subcomponent(modules = [ListArticlesPresenterModule::class, ListArticlesViewModule::class])
interface ListArticlesComponent {

    fun injectListArticlesFragment(fragment: ListArticlesFragment)
}