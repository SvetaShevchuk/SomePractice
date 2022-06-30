package com.wordEasyRemember.wordeasyremember.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ActivityGhiBinding

class ActivityGHI : AppCompatActivity() {
    lateinit var binding: ActivityGhiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGhiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemGHI = intent.getSerializableExtra("itemGHI") as ViewModelWord

        binding.apply {
            textViewWordGHI.text = itemGHI.word
            textViewTranslationGHI.text = itemGHI.translation
            textViewAssociationGHI.text = itemGHI.association
        }

    }
}