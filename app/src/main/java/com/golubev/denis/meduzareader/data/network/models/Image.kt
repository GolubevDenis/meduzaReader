package com.golubev.denis.meduzareader.data.network.models

import com.google.gson.annotations.SerializedName

data class Image(
        @SerializedName("small_url") var smallUrl: String? = null,
        @SerializedName("large_url") var largeUrl: String? = null
)
