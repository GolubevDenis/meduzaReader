package com.golubev.denis.meduzareader.data.network.models

import com.google.gson.annotations.SerializedName

data class ListArticlesResponse(
        @SerializedName("has_next") var hasNext: Boolean? = null,
        @SerializedName("collection") var collection: List<String>? = null,
        @SerializedName("_count") var count: Int? = null
)

