package com.golubev.denis.meduzareader.data.network.models

import com.google.gson.annotations.SerializedName

data class Root(
        @SerializedName("title") var title: String,
        @SerializedName("image") var image: Image?,
        @SerializedName("share_image") var shareImage: String,
        @SerializedName("content") var content: Content,
        @SerializedName("description") var description: String,
        @SerializedName("url") var url: String,
        @SerializedName("modified_at") var modifiedAt: Long,
        @SerializedName("published_at") var publishedAt: Long,
        @SerializedName("gallery") var gallery: List<Gallery>?
)
