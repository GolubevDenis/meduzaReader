package com.golubev.denis.meduzareader.data.database.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/*
* It's just a wrapper over the string.
 */
open class ImageForListDB : RealmObject() {
    @PrimaryKey
    var url: String? = null
}