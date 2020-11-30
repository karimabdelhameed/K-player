package com.kagroup.kplayer.ui.main.adapters

import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import com.kagroup.kplayer.R
import com.kagroup.kplayer.base.BaseSongAdapter
import kotlinx.android.synthetic.main.list_item.view.*
import javax.inject.Inject

/**
 * Created by karim on 30,November,2020
 */

class SongsListAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseSongAdapter(R.layout.list_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {
            tvPrimary.text = song.title
            tvSecondary.text = song.sub_title
            glide.load(song.thumbnail).into(ivItemImage)

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }
}

