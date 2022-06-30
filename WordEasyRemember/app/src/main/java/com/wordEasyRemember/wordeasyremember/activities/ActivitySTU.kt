package com.wordEasyRemember.wordeasyremember.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ActivityStuBinding

class ActivitySTU : AppCompatActivity() {
    lateinit var binding: ActivityStuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemSTU = intent.getSerializableExtra("itemSTU") as ViewModelWord

        binding.apply {
            textViewWordSTU.text = itemSTU.word
            textViewTranslationSTU.text = itemSTU.translation
            textViewAssociationSTU.text = itemSTU.association
        }

    }
}