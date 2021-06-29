package com.yoonlab.clipuitest

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.yoonlab.clipuitest.Adapter.EpisodeListAdapter


class EpisodListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episod_list)

        // For Collapsing ToolBar Title. Title Should be replaced with title String value retrieved
        // from intent.
        val collapsingToolBar: CollapsingToolbarLayout = findViewById(R.id.collapsingToolBarEpisodeList)
        collapsingToolBar.title = "다시만난 너"

        collapsingToolBar.setExpandedTitleColor(Color.TRANSPARENT)
        collapsingToolBar.setCollapsedTitleTextColor(Color.WHITE)

        // Sample Data Set
        val sampleThumbnailSet = resources.obtainTypedArray(R.array.drama_page_test_1)
        val sampleTitleSet = ArrayList<String>(6)
        sampleTitleSet.add("짝사랑을 들키면 안 되는 이유")
        sampleTitleSet.add("전학생에게 친구를 뻇겼다")
        sampleTitleSet.add("너 내 남친이랑 뭐해?")
        sampleTitleSet.add("친구들이 나를 싫어한다")
        sampleTitleSet.add("친구들에게 과거를 숨긴 이유")
        sampleTitleSet.add("노래방 씬 찢어버린 현직 아이돌")

        val epListRecyclerView: RecyclerView = findViewById(R.id.dramaListRecyclerView)
        val mainAdapter = EpisodeListAdapter(sampleThumbnailSet, sampleTitleSet, this)
        epListRecyclerView.adapter = mainAdapter

    }
}