package com.golubev.denis.meduzareader.data.network.models

import com.google.gson.annotations.SerializedName

data class Content(
        @SerializedName("body") var body: String? = null
)
