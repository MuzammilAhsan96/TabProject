package com.example.tabproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.tabproject.fragments.StatusFragment
import com.example.tabproject.fragments.ChatFragment
import com.example.tabproject.fragments.CallsFragment
import com.example.tabproject.adapters.ChatAdapter
import com.example.tabproject.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var rcv: RecyclerView
    private lateinit var radapter: ChatAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTabs()
    }

    private fun setUpTabs() {

        val viewpager = findViewById<ViewPager>(R.id.AppViewPager)
        val tablayout = findViewById<TabLayout>(R.id.tabs)
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(ChatFragment(), title = "Chats")
        adapter.addFragment(StatusFragment(), title = "Status")
        adapter.addFragment(CallsFragment(), title = "Calls")

        viewpager.adapter = adapter
        tablayout.setupWithViewPager(viewpager)

        tablayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tablayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_favorite_24)
        tablayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_settings_24)


    }

}