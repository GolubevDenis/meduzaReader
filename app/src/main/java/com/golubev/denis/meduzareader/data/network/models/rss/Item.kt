package com.golubev.denis.meduzareader.data.network.models.rss

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
class Item {

    var guid: String? = null
        @Element(name = "guid", required = false) get
        @Element(name = "guid", required = false) set

    var date: String? = null
        @Element(name = "pubDate", required = false) get
        @Element(name = "pubDate", required = false) set

    var title: String? = null
        @Element(name = "title", required = false) get
        @Element(name = "title", required = false) set

    var enclosure: Enclosure? = null
        @Element(name = "enclosure", required = false) get
        @Element(name = "enclosure", required = false) set

    var description: String? = null
        @Element(name = "description", required = false) get
        @Element(name = "description", required = false) set

    var link: String? = null
        @Element(name = "link", required = false) get
        @Element(name = "link", required = false) set

    override fun toString(): String {
        return description + " \n" + guid
    }
}

