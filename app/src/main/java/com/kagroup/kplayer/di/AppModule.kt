package com.kagroup.kplayer.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kagroup.kplayer.R
import com.kagroup.kplayer.exoPlayer.MusicServiceConnection
import com.kagroup.kplayer.ui.main.adapters.SwipeSongAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by karim on 28,November,2020
 */
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGlide(@ApplicationContext context: Context) =
        Glide.with(context).applyDefaultRequestOptions(
            RequestOptions()
                .error(R.drawable.ic_image)
                .placeholder(R.drawable.ic_image)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
        )

    @Singleton
    @Provides
    fun provideMusicServiceConnection(@ApplicationContext context: Context) =
        MusicServiceConnection(context)

    @Singleton
    @Provides
    fun provideSwipeSongAdapter() = SwipeSongAdapter()
}