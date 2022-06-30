package com.wordEasyRemember.wordeasyremember.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ActivityAbcBinding

class ActivityABC : AppCompatActivity() {
    lateinit var binding: ActivityAbcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemABC = intent.getSerializableExtra("itemABC") as ViewModelWord

        binding.apply {
            textViewWord.text = itemABC.word
            textViewTranslation.text = itemABC.translation
            textViewAssociation.text = itemABC.association
        }


    }
}