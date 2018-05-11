package com.golubev.denis.meduzareader.presentation.ui.articles

import android.content.res.Configuration
import android.os.Bundle
import android.widget.FrameLayout
import com.golubev.denis.meduzareader.MyApplication
import com.golubev.denis.meduzareader.R
import com.golubev.denis.meduzareader.domain.global.models.Article
import com.golubev.denis.meduzareader.presentation.mvp.articles.ArticlesActivityPresenter
import com.golubev.denis.meduzareader.presentation.mvp.articles.ArticlesActivityView
import com.golubev.denis.meduzareader.presentation.ui.articles.details.DetailsArticleFragment
import com.golubev.denis.meduzareader.presentation.ui.global.extension.addFragment
import com.golubev.denis.meduzareader.presentation.ui.global.extension.setFragment
import com.golubev.denis.meduzareader.presentation.ui.articles.list.ListArticlesFragment
import com.golubev.denis.meduzareader.presentation.ui.global.extension.isOrientationVertical
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import android.R.attr.orientation
import android.databinding.DataBindingUtil
import android.view.OrientationEventListener
import android.view.View
import android.widget.ImageView
import com.golubev.denis.meduzareader.databinding.ActivityArticlesBinding


class ArticlesActivity :
        MvpActivity<ArticlesActivityView, ArticlesActivityPresenter>(),
        ArticlesActivityView, ListArticlesFragment.OnItemClicked {

    override fun createPresenter(): ArticlesActivityPresenter {
        return MyApplication.getApplicationComponent()
                .getArticlesActivityComponent()
                .getPresenter()
    }

    private var detailsFragment: DetailsArticleFragment? = null
    private var listFragment: ListArticlesFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        if(savedInstanceState == null){
            listFragment = ListArticlesFragment.newInstance()
            addFragment(R.id.container, listFragment!!)
        }
        val details = supportFragmentManager.findFragmentById(R.id.container_details)
        if(details != null){
            findViewById<View>(R.id.placeholder)?.visibility = View.INVISIBLE
        }
    }

    override fun onClicked(article: Article) {
        if (isTablet()){
            if(detailsFragment == null){
                detailsFragment = DetailsArticleFragment.newInstance(article)
                setFragment(R.id.container_details, detailsFragment!!)
            }else {
                detailsFragment!!.showArticle(article)
            }
            findViewById<View>(R.id.placeholder).visibility = View.INVISIBLE
        }else{
            setFragment(R.id.container, DetailsArticleFragment.newInstance(article), true)
        }
    }

    private fun isTablet() = findViewById<FrameLayout>(R.id.container_details) != null && !isOrientationVertical()

    override fun onDestroy() {
        super.onDestroy()
        detailsFragment = null
        listFragment = null
    }

}
