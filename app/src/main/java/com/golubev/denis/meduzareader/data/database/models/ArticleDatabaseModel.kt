package com.golubev.denis.meduzareader.data.database.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ArticleDatabaseModel : RealmObject() {

    @PrimaryKey var url: String? = null

    var title: String? = null
    var modifiedAt: Long? = null
    var publishedAt: Long? = null
    var imageUrl: String? = null
    var shareImageUrl: String? = null
    var description: String? = null
    var content: String? = null
    var listImagesUrl: RealmList<ImageForListDB>? = null

    fun copyFrom(model: ArticleDatabaseModel){
        title = model.title
        modifiedAt = model.modifiedAt
        publishedAt = model.publishedAt
        imageUrl = model.imageUrl
        shareImageUrl = model.shareImageUrl
        description = model.description
        content = model.content
        listImagesUrl = model.listImagesUrl
    }

    companion object {
        const val URL = "url"
        const val TITLE = "title"
        const val MODIFIED_AT = "modifiedAt"
        const val PUBLISHED_AT = "publishedAt"
        const val UMAGE_URL = "imageUrl"
        const val SHARE_IMAGE_URL = "shareImageUrl"
        const val DESCRIPTION = "description"
        const val CONTENT = "content"
        const val LIST_IMAGES_URL = "listImagesUrl"
    }

}