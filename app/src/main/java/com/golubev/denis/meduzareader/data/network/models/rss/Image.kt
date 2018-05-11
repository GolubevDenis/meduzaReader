package com.golubev.denis.meduzareader.data.network.models.rss

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "image", strict = false)
class Image{
    var title: String? = null @Element get @Element set
//    var link: String? = null @Element get @Element set
    var url: String? = null @Element get @Element set
}

