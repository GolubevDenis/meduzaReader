package com.golubev.denis.meduzareader.presentation.ui.articles.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.golubev.denis.meduzareader.databinding.FragmentDetailsArticleBinding
import com.golubev.denis.meduzareader.domain.global.models.Article

class DetailsArticleFragment : Fragment() {

    private var article: Article? = null
    private lateinit var binder: FragmentDetailsArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            article = arguments!!.getParcelable(ARTICLE_PARAM) as Article
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binder = FragmentDetailsArticleBinding.inflate(inflater)
        binder.article = article
        return binder.root
    }

    fun showArticle(newArticle: Article){
        article = newArticle
        binder.article = article
    }

    companion object {
        private val ARTICLE_PARAM = "com.golubev.denis.meduzareader.presentation.ui.articles.details.DetailsArticleFragment.ARTICLE_PARAM"

        fun newInstance(article: Article): DetailsArticleFragment {
            val fragment = DetailsArticleFragment()
            val args = Bundle()
            args.putParcelable(ARTICLE_PARAM, article)
            fragment.arguments = args
            return fragment
        }
        fun newInstance() = DetailsArticleFragment()
    }
}
