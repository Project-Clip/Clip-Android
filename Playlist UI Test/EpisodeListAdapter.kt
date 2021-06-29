package com.yoonlab.clipuitest.Adapter

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yoonlab.clipuitest.R

class EpisodeListAdapter(val sampleItems: TypedArray, val titleSample: ArrayList<String>, val context: Context)
    : RecyclerView.Adapter<EpisodeAdapterMainViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EpisodeAdapterMainViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.playlist_item_layout, parent, false)
        return EpisodeAdapterMainViewHolder(inflatedView, context)
    }

    override fun onBindViewHolder(holder: EpisodeAdapterMainViewHolder, position: Int) {
        val thumbnailImage = sampleItems.getDrawable(position)
        val title = titleSample.get(position)
        holder.apply {
            itemBinder(thumbnailImage, title, position + 1)
        }
    }

    override fun getItemCount(): Int {
        if (sampleItems.length() != titleSample.size) {
            if (sampleItems.length() < titleSample.size) return sampleItems.length()
            else return titleSample.size
        } else return sampleItems.length()
    }
}

class EpisodeAdapterMainViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view) {
    val itemContainer: View = view
    fun itemBinder(image: Drawable?, title: String, epNumber: Int) {
        val thumbnail: ImageView = itemContainer.findViewById(R.id.thumbnailImage)
        val titleText: TextView = itemContainer.findViewById(R.id.epTitleText)
        val epNumberText: TextView = itemContainer.findViewById(R.id.epNumber)

        thumbnail.setImageDrawable(image)
        titleText.setText(title)
        epNumberText.setText("EP. $epNumber")
    }
}