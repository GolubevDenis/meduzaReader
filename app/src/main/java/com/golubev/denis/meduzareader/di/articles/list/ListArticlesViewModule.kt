package com.golubev.denis.meduzareader.di.articles.list

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.golubev.denis.meduzareader.di.global.scopes.Presenter
import com.golubev.denis.meduzareader.presentation.ui.articles.list.ArticleHolder
import com.golubev.denis.meduzareader.presentation.ui.articles.list.ArticlesRecyclerAdapter
import dagger.Module
import dagger.Provides

@Module
class ListArticlesViewModule(
        fragment: Fragment
) {

    private val inflater = fragment.layoutInflater

    @Presenter
    @Provides
    fun provideInflater()
            = inflater

    @Presenter
    @Provides
    fun provideArticlesAdapter(adapter: ArticlesRecyclerAdapter): RecyclerView.Adapter<ArticleHolder>
            = adapter
}