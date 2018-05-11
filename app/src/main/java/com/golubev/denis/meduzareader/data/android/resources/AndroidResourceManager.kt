package com.golubev.denis.meduzareader.data.android.resources

import android.content.Context

class AndroidResourceManager(
        private val context: Context
) : ResourceManager {

    override fun getString(resourceId: Int): String {
        return context.resources.getString(resourceId)
    }

    override fun getInteger(resourceId: Int): Int {
        return context.resources.getInteger(resourceId)
    }

}