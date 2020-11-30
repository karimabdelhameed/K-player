package com.kagroup.kplayer.exoPlayer

import android.support.v4.media.MediaMetadataCompat
import com.kagroup.kplayer.data.Song

/**
 * Created by karim on 30,November,2020
 */
fun MediaMetadataCompat.toSong() : Song? {
    return description?.let {
        Song(it.mediaId ?: "",
        it.title.toString(),
        it.subtitle.toString(),
        it.mediaUri.toString(),
        it.iconUri.toString())
    }
}