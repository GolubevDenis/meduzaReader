package com.golubev.denis.meduzareader.presentation.mvp.articles

import com.golubev.denis.meduzareader.domain.global.models.Article
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject

class ArticlesActivityPresenter @Inject constructor(

): MvpBasePresenter<ArticlesActivityView>()