package com.kagroup.kplayer.ui.song

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kagroup.kplayer.exoPlayer.MusicService
import com.kagroup.kplayer.exoPlayer.MusicServiceConnection
import com.kagroup.kplayer.exoPlayer.currentPlaybackPosition
import com.kagroup.kplayer.utils.Constants.UPDATE_PLAYER_POSITION_INTERVAL
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by karim on 30,November,2020
 */
class SongViewModel @ViewModelInject constructor(
    musicServiceConnection: MusicServiceConnection
) : ViewModel() {

    private val playbackState = musicServiceConnection.playbackState

    private val _curSongDuration = MutableLiveData<Long>()
    val curSongDuration: LiveData<Long> = _curSongDuration

    private val _curPlayerPosition = MutableLiveData<Long>()
    val curPlayerPosition: LiveData<Long> = _curPlayerPosition


    init {
        updateCurPlayerPosition()
    }

    private fun updateCurPlayerPosition() {
        viewModelScope.launch {
            while (true) {
                val position = playbackState.value?.currentPlaybackPosition
                if (curPlayerPosition.value != position) {
                    _curPlayerPosition.postValue(position)
                    _curSongDuration.postValue(MusicService.currentSongDuration)
                }
                delay(UPDATE_PLAYER_POSITION_INTERVAL)
            }
        }
    }


}