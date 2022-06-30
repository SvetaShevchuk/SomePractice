package com.wordEasyRemember.wordeasyremember.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ActivityVwxBinding

class ActivityVWX : AppCompatActivity() {
    lateinit var binding: ActivityVwxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVwxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemVWX = intent.getSerializableExtra("itemVWX") as ViewModelWord

        binding.apply {
            textViewWordVWX.text = itemVWX.word
            textViewTranslationVWX.text = itemVWX.translation
            textViewAssociationVWX.text = itemVWX.association
        }

    }
}