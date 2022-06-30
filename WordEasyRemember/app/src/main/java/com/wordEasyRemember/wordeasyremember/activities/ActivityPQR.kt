package com.wordEasyRemember.wordeasyremember.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ActivityPqrBinding

class ActivityPQR : AppCompatActivity() {

    lateinit var binding: ActivityPqrBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPqrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemPQR = intent.getSerializableExtra("itemPQR") as ViewModelWord

        binding.apply {
            textViewWordPQR.text = itemPQR.word
            textViewTranslationPQR.text = itemPQR.translation
            textViewAssociationPQR.text = itemPQR.association
        }

    }
}