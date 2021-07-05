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
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.yoonlab.clipuitest.EpisodListActivity
import com.yoonlab.clipuitest.R
import org.w3c.dom.Text

class MainContentViewPagerAdapter(val imageSet :TypedArray, val titleText: ArrayList<String>,
                                  val context: Context): RecyclerView.Adapter<MainContentViewPagerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainContentViewPagerViewHolder {
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item, parent, false)
        return MainContentViewPagerViewHolder(inflatedView, context)
    }

    override fun onBindViewHolder(holder: MainContentViewPagerViewHolder, position: Int) {
        val targetImage = imageSet.getDrawable(position)
        val title = titleText.get(position)
        holder.apply {
            itemBinder(targetImage, title, context)
        }
    }

    override fun getItemCount(): Int {
        if (imageSet.length() != titleText.size) {
            if (imageSet.length() < titleText.size) return imageSet.length()
            else return titleText.size
        } else return imageSet.length()
    }
}

class MainContentViewPagerViewHolder(view: View, context: Context): RecyclerView.ViewHolder(view) {
    val itemContainer: View = view
    fun itemBinder(data: Drawable?, title: String, context: Context) {
        val titleText = itemContainer.findViewById<TextView>(R.id.mainContentTitle)
        titleText.setText(title)
        val imageView = itemContainer.findViewById<ImageView>(R.id.contentImageView)
        Glide.with(context).load(data).into(imageView)

        imageView.setOnClickListener() {
            val intentItem = Intent(context, EpisodListActivity::class.java)
            intentItem.putExtra("title", title)
            startActivity(context, intentItem, null)
        }
    }
}