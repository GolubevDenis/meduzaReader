package com.golubev.denis.meduzareader.presentation.ui.global.binding

import android.databinding.BindingAdapter
import android.os.Build
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.widget.TextView
import com.golubev.denis.meduzareader.R

@BindingAdapter("bind:textMax100Chars")
fun textMax100Chars(view: TextView, text: String){
    if(text.length > 100)
        view.text = view.context.getString(R.string.shorted_text,
                text.substring(0, text.lastIndexOf(" ", 100)))
    else view.text = text
}

@BindingAdapter("bind:textHtml")
fun textHtml(view: TextView, text: String?){
    text?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) view.text = Html.fromHtml(it, Html.FROM_HTML_MODE_COMPACT)
        else view.text = Html.fromHtml(it)
    }
}

@BindingAdapter("bind:countColumns")
fun countColumns(view: RecyclerView, count: Int){
    if(count == 0) throw IllegalArgumentException("Count columns of RecyclerView must be more than 0")
    view.layoutManager =
            if(count == 1) LinearLayoutManager(view.context)
            else GridLayoutManager(view.context, count)
}

@BindingAdapter("bind:visibleIfNull")
fun visibleIfNull(view: View, obj: Any?){
    view.visibility =
            if(obj == null) View.VISIBLE
            else View.GONE
}




