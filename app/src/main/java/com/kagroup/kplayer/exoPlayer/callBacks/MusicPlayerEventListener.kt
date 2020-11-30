package com.kagroup.kplayer.exoPlayer.callBacks

import android.widget.Toast
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.Player
import com.kagroup.kplayer.exoPlayer.MusicService

/**
 * Created by karim on 28,November,2020
 */
class MusicPlayerEventListener(
    private val musicService: MusicService
) : Player.EventListener {

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)
        if(playbackState == Player.STATE_READY && !playWhenReady){
            musicService.stopForeground(false)

        }
    }

    override fun onPlayerError(error: ExoPlaybackException) {
        super.onPlayerError(error)
        Toast.makeText(musicService, "Unknown error occurred", Toast.LENGTH_LONG).show()
    }
}