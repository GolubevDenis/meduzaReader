package com.golubev.denis.meduzareader.presentation.ui.articles.list

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.golubev.denis.meduzareader.MyApplication
import com.golubev.denis.meduzareader.R
import com.golubev.denis.meduzareader.databinding.FragmentListArticlesBinding
import com.golubev.denis.meduzareader.di.articles.list.ListArticlesViewModule
import com.golubev.denis.meduzareader.domain.global.models.Article
import com.golubev.denis.meduzareader.presentation.mvp.articles.list.ListArticlesView
import com.golubev.denis.meduzareader.presentation.mvp.articles.list.ListFragmentPresenter
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import javax.inject.Inject

class ListArticlesFragment :
        MvpFragment<ListArticlesView, ListFragmentPresenter>(),
        ListArticlesView {

    interface OnItemClicked{
        fun onClicked(article: Article)
    }

    private var onItemClicked: OnItemClicked? = null
    private lateinit var binder: FragmentListArticlesBinding
    @Inject lateinit var adapter: ArticlesRecyclerAdapter
    @Inject lateinit var daggerInjectedPresenter: ListFragmentPresenter

    companion object {
        private const val CACHE_SIZE_ADAPTER = 10
        fun newInstance() = ListArticlesFragment()
    }

    override fun createPresenter(): ListFragmentPresenter {
        injectDependencies()
        return daggerInjectedPresenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        onItemClicked = context as? OnItemClicked
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binder = FragmentListArticlesBinding.inflate(inflater)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initListeners()
        presenter.firstLoadArticles()
    }

    private fun initRecycler(){
//        if(context!!.isOrientationVertical()) binder.recyclerView.layoutManager = LinearLayoutManager(context)
//        else binder.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binder.list.recyclerView.adapter = adapter
        binder.list.recyclerView.setItemViewCacheSize(CACHE_SIZE_ADAPTER)
        binder.list.recyclerView.isDrawingCacheEnabled = true
        binder.list.recyclerView.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
    }

    override fun onDetach() {
        super.onDetach()
        binder.list.recyclerView.layoutManager = null
    }

    private fun initListeners(){
        binder.listContainer.setOnRefreshListener {
            presenter.refreshArticles()
        }
        adapter.onListEndedListener = {
            showLoadingMoreProgress()
            presenter.loadMoreArticles()
        }
        adapter.onItemClickListener = {
            onItemClicked?.onClicked(it)
        }
    }

    private fun injectDependencies(){
        MyApplication.getApplicationComponent()
                .getArticlesListComponent(ListArticlesViewModule(this))
                .injectListArticlesFragment(this)
    }

    override fun showArticles(list: List<Article>) {
        adapter.setArticles(list)
        binder.plaheholder.visibility = if(list.isEmpty()) View.VISIBLE else View.INVISIBLE
    }

    override fun showNewArticles(list: List<Article>) {
        adapter.addArticles(list)
    }

    override fun showLoadingProgress() {
        binder.listContainer.isRefreshing = true
    }

    override fun showLoadingMoreProgress() {
        binder.loadMoreProgress.visibility = View.VISIBLE
    }

    override fun hideLoadingProgress() {
        binder.listContainer.isRefreshing = false
    }

    override fun hideLoadingMoreProgress() {
        binder.loadMoreProgress.visibility = View.GONE
    }

    override fun showErrorLoading() {
        Snackbar.make(binder.root, getString(R.string.error), Snackbar.LENGTH_SHORT).show()
    }
}

