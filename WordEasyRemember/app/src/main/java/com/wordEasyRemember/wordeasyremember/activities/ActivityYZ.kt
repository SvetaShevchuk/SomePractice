package com.wordEasyRemember.wordeasyremember.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ActivityYzBinding

class ActivityYZ : AppCompatActivity() {
    lateinit var binding: ActivityYzBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemYZ = intent.getSerializableExtra("itemYZ") as ViewModelWord

        binding.apply {
            textViewWordYZ.text = itemYZ.word
            textViewTranslationYZ.text = itemYZ.translation
            textViewAssociationYZ.text = itemYZ.association
        }

    }
}