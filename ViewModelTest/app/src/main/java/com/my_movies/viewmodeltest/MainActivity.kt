package com.my_movies.viewmodeltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : MainViewModel
    lateinit var button: Button
    lateinit var count: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        button = findViewById(R.id.button)
        count = findViewById(R.id.tvText)
        count.text = viewModel.countNumber.toString()

        viewModel.countNumber.observe(this, Observer {
            count.text = it.toString()
        })

        button.setOnClickListener {
            viewModel.update()
        }
    }
}