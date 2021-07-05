package com.yoonlab.clipuitest

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.yoonlab.clipuitest.Adapter.MainContentViewPagerAdapter
import com.yoonlab.clipuitest.Adapter.UploadedTodayAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testImageSet = this.resources.obtainTypedArray(R.array.test_poster_set)
        val testTitleSet = ArrayList<String>(4)
        testTitleSet.add("다시 만난 너")
        testTitleSet.add("너와 결혼하기 싫은 8가지 이유")
        testTitleSet.add("트웬티트웬티")
        testTitleSet.add("7일만 로멘스2")

        val mainContentViewPager: ViewPager2 = findViewById<ViewPager2>(R.id.mainContentViewPager)
        val adapter = MainContentViewPagerAdapter(testImageSet, testTitleSet, this)
        mainContentViewPager.adapter = adapter

        val uploadTodayRecyclerView: RecyclerView = findViewById<RecyclerView>(R.id.uploadedTodayRecyclerView)
        uploadTodayRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        uploadTodayRecyclerView.adapter = UploadedTodayAdapter(testImageSet, testTitleSet, this)

    }
}