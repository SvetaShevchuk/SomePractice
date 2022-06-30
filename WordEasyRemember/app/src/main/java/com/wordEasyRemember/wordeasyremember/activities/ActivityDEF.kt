package com.wordEasyRemember.wordeasyremember.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ActivityDefBinding

class ActivityDEF : AppCompatActivity() {
    lateinit var binding : ActivityDefBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDefBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemDEF = intent.getSerializableExtra("itemDEF") as ViewModelWord

        binding.apply {
            textViewWordDEF.text = itemDEF.word
            textViewTranslationDEF.text = itemDEF.translation
            textViewAssociationDEF.text = itemDEF.association
        }
    }
}