package com.golubev.denis.meduzareader.data.network.models.rss

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
class Rss {

    var channel: Channel? = null
    @Element(name = "channel") get
    @Element(name = "channel") set

    var version: String? = null
    @Attribute(name = "version", required = false) get
    @Attribute(name = "version", required = false) set

}

