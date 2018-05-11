package com.golubev.denis.meduzareader.presentation.ui.global.extension

import android.content.Context
import android.content.res.Configuration.ORIENTATION_PORTRAIT

fun Context.isOrientationVertical() = resources.configuration.orientation == ORIENTATION_PORTRAIT