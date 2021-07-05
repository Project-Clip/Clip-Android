package com.yoonlab.clipuitest.Adapter

import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yoonlab.clipuitest.EpisodListActivity
import com.yoonlab.clipuitest.R

class UploadedTodayAdapter(val testImagSet: TypedArray, val testTitles: ArrayList<String>,
                           val context: Context) : RecyclerView.Adapter<UploadedTodayViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UploadedTodayViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.uploaded_today_recycler_view_item, parent, false)
        return UploadedTodayViewHolder(inflatedView, context)
    }

    override fun onBindViewHolder(holder: UploadedTodayViewHolder, position: Int) {
        val targetPoster = testImagSet.getDrawable(position)
        val targetTitle = testTitles.get(position)
        holder.apply {
            itemBinder(targetPoster, targetTitle, context)
        }
    }

    override fun getItemCount(): Int {
        if (testImagSet.length() != testTitles.size) {
            if (testImagSet.length() < testTitles.size) return testImagSet.length()
            else return testTitles.size
        } else return testImagSet.length()
    }
}

class UploadedTodayViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view) {
    val itemContainer = view

    fun itemBinder(poster: Drawable?, title: String, context: Context) {
        val posterView = itemContainer.findViewById<ImageView>(R.id.posterView)
        val titleView = itemContainer.findViewById<TextView>(R.id.titleTextView)
        Glide.with(context).load(poster).into(posterView)
        titleView.setText(title)

        posterView.setOnClickListener {
            val intentItem = Intent(context, EpisodListActivity::class.java)
            intentItem.putExtra("title", title)
            startActivity(context, intentItem, null)
        }
    }
}