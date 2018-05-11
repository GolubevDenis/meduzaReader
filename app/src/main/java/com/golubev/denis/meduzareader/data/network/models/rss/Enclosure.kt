package com.golubev.denis.meduzareader.data.network.models.rss

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "enclosure")
class Enclosure{

    var length: String? = null @Attribute get @Attribute set
    var type: String? = null @Attribute get @Attribute set
    var url: String? = null @Attribute get @Attribute set
}