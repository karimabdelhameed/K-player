package com.kagroup.kplayer.data

/**
 * Created by karim on 24,November,2020
 */
data class Song(
//    @SerializedName("media_id")
    val media_id: String? = "",
    val title: String? = "",
//    @SerializedName("sub_title")
    val sub_title: String? = "",
//    @SerializedName("song_url")
    val song_url: String? = "",
    val thumbnail: String? = ""
) {}