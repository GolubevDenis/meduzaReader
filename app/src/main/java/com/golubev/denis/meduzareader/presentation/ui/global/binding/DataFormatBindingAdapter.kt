package com.golubev.denis.meduzareader.presentation.ui.global.binding

import android.databinding.BindingAdapter
import android.widget.TextView
import java.text.DateFormat
import java.util.*

class DataFormatBindingAdapter(
        val dateFormat: DateFormat
){
    @BindingAdapter("bind:dateFormat")
    fun dateFormat(view: TextView, date: Date){
        view.text = dateFormat.format(date)
    }
}