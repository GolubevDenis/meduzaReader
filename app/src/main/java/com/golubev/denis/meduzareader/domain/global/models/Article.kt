package com.golubev.denis.meduzareader.domain.global.models

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Article(
        val title: String,
        val modifiedAt: Date,
        val publishedAt: Date,
        val imageUrl: String?,
        val shareImageUrl: String,
        val description: String,
        val content: String?,
        val url: String,
        val listImagesUrl: List<String>?
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            Date(parcel.readLong()),
            Date(parcel.readLong()),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeLong(modifiedAt.time)
        parcel.writeLong(publishedAt.time)
        parcel.writeString(imageUrl)
        parcel.writeString(shareImageUrl)
        parcel.writeString(description)
        parcel.writeString(content)
        parcel.writeString(url)
        parcel.writeStringList(listImagesUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }
}