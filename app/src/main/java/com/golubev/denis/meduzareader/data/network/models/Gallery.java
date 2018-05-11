
package com.golubev.denis.meduzareader.data.network.models;

import com.google.gson.annotations.SerializedName;

public class Gallery {

    @SerializedName("id") public Integer id;
    @SerializedName("original_url") public String originalUrl;
    @SerializedName("large_url") public String largeUrl;
    @SerializedName("small_url") public String smallUrl;
}
