package com.kagroup.kplayer.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.kagroup.kplayer.data.Song
import com.kagroup.kplayer.utils.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await

/**
 * Created by karim on 24,November,2020
 */
class MusicDatabase {
    private val fireStore = FirebaseFirestore.getInstance()
    private val songCollection = fireStore.collection(SONG_COLLECTION)

    suspend fun getAllSongs() : List<Song>{
        return try{
            songCollection.get().await().toObjects(Song::class.java)
        }
        catch (e:Exception){
            emptyList()
        }
    }
}