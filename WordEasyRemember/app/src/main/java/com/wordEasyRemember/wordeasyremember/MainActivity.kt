package com.wordEasyRemember.wordeasyremember

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.wordEasyRemember.wordeasyremember.databinding.ActivityMainBinding
import com.wordEasyRemember.wordeasyremember.fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragList = listOf(
                            FragmentABC.newInstance(),
                            FragmentDEF.newInstance(),
                            FragmentGHI.newInstance(),
                            FragmentJKL.newInstance(),
                            FragmentMNO.newInstance(),
                            FragmentPQR.newInstance(),
                            FragmentSTU.newInstance(),
                            FragmentVWX.newInstance(),
                            FragmentYZ.newInstance())
    private val fragListTitles = listOf(
        "ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX", "YZ")

    private val fragListTabIndicators = listOf(
        R.drawable.tab_indicator,
        R.drawable.tab_indicator,
        R.drawable.tab_indicator,
        R.drawable.tab_indicator,
        R.drawable.tab_indicator,
        R.drawable.tab_indicator,
        R.drawable.tab_indicator,
        R.drawable.tab_indicator,
        R.drawable.tab_indicator,
        R.drawable.tab_indicator)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = VpAdapter(this, fragList)
        binding.vp2.adapter = adapter
        TabLayoutMediator(binding.tb, binding.vp2){
            tab, pos -> tab.text = fragListTitles[pos]
        }.attach()

    }
}