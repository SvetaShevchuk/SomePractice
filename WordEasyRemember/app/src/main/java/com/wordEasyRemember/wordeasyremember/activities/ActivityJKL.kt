package com.wordEasyRemember.wordeasyremember.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ActivityJklBinding

class ActivityJKL : AppCompatActivity() {
    lateinit var binding: ActivityJklBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJklBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemJKL = intent.getSerializableExtra("itemJKL") as ViewModelWord

        binding.apply {
            textViewWordJKL.text = itemJKL.word
            textViewTranslationJKL.text = itemJKL.translation
            textViewAssociationJKL.text = itemJKL.association
        }

    }
}