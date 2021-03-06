package com.kagroup.kplayer.ui.main.adapters

/**
 * Created by karim on 30,November,2020
 */

import androidx.recyclerview.widget.AsyncListDiffer
import com.kagroup.kplayer.R
import com.kagroup.kplayer.base.BaseSongAdapter
import kotlinx.android.synthetic.main.swipe_item.view.*

class SwipeSongAdapter : BaseSongAdapter(R.layout.swipe_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {
            val text = "${song.title} - ${song.sub_title}"
            tvPrimary.text = text

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }

}