package com.golubev.denis.meduzareader.presentation.ui.global.binding

import android.databinding.BindingAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class ImageUrlBindingAdapter(
        val picasso: Picasso
){
    @BindingAdapter("bind:imageUrl")
    fun imageUrl(view: ImageView, url: String?){
        if(url != null)
            picasso.load(url)
                    .fit()
                    .into(view, object : Callback{
                        override fun onSuccess() {}
                        override fun onError(e: Exception?) {
                            view.visibility = View.GONE
                        }
                    })
        else
            view.visibility = View.GONE
    }

    @BindingAdapter("bind:listImagesUrl")
    fun listImagesUrl(view: ViewGroup, urls: List<String>?){
        if(urls != null){
            urls.forEach {
                val image = ImageView(view.context)
                view.addView(image)
                picasso.load(it)
                        .fit()
                        .into(image, object : Callback{
                            override fun onSuccess() {}
                            override fun onError(e: Exception?) {
                                view.visibility = View.GONE
                            }
                        })
            }
        } else
            view.visibility = View.GONE
    }
}