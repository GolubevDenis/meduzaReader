package com.golubev.denis.meduzareader.data.network.models.rss

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
class Channel{

    var title: String? = null @Element get @Element set
//    var description: String? = null  @Element get @Element set
//    var link: String? = null  @Element get @Element set
    var item: List<Item>? = null @ElementList(inline = true, name = "item") get @ElementList(inline = true, name = "item") set
//    var image: Image? = null  @Element get @Element set
    var language: String? = null  @Element get @Element set
}