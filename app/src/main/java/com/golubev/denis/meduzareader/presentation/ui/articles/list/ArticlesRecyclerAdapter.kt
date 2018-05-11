package com.golubev.denis.meduzareader.presentation.ui.articles.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.golubev.denis.meduzareader.databinding.ArticleItemBinding
import com.golubev.denis.meduzareader.domain.global.models.Article
import javax.inject.Inject

class ArticlesRecyclerAdapter @Inject constructor(
        private val inflater: LayoutInflater
) : RecyclerView.Adapter<ArticleHolder>(){

    var onListEndedListener: (() -> Unit)? = null
    var onItemClickListener: ((Article) -> Unit)? = null
    private val list = arrayListOf<Article>()

    fun addArticles(newArticles: List<Article>){
        val fromPosition = list.size
        val toPosition = newArticles.size
        list.addAll(newArticles)
        notifyItemChanged(fromPosition, toPosition)
    }

    fun setArticles(newArticles: List<Article>){
        list.clear()
        list.addAll(newArticles)
        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val binder = ArticleItemBinding.inflate(inflater, parent, false)
        return ArticleHolder(binder)
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        val article = list[position]
        holder.bind(article)
        onItemClickListener?.let {
            holder.setClickListener(it, article)
        }
        // Если последний элемент списка - вызвать лисенер
        if(position == itemCount - 1)
            onListEndedListener?.invoke()

    }
}

class ArticleHolder(
        val binder: ArticleItemBinding
) : RecyclerView.ViewHolder(binder.root){

    fun bind(article: Article){
        binder.article = article
    }

    fun setClickListener(listener: ((Article) -> Unit), article: Article){
        binder.root.setOnClickListener {
            listener.invoke(article)
        }
    }
}