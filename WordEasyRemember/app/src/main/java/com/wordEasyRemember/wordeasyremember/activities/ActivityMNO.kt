package com.wordEasyRemember.wordeasyremember.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ActivityMnoBinding

class ActivityMNO : AppCompatActivity() {
    lateinit var  binding: ActivityMnoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMnoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemMNO = intent.getSerializableExtra("itemMNO") as ViewModelWord

        binding.apply {
            textViewWordMNO.text = itemMNO.word
            textViewTranslationMNO.text = itemMNO.translation
            textViewAssociationMNO.text = itemMNO.association
        }

    }
}