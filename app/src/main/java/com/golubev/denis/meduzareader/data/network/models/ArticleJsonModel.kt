package com.golubev.denis.meduzareader.data.network.models

import com.google.gson.annotations.SerializedName

data class ArticleJsonModel(
        @SerializedName("root") var root: Root
)
