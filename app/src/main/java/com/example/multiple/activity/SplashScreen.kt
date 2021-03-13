package com.example.multiple.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import com.example.domain.entity.Result
import com.example.multiple.R
import com.example.multiple.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private val mainViewModel:MainViewModel by viewModels()

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        imageView = findViewById(R.id.logo)
        textView = findViewById(R.id.error_text)
        button = findViewById(R.id.retryButton)
        progressBar = findViewById(R.id.progressbar)

        mainViewModel.getData()
        setupObserver()

    }

    private fun setupObserver(){

        mainViewModel.questionModel.observe(this, {

            when(it){

                is Result.Loading -> {
                    imageView.visibility = View.VISIBLE
                    progressBar.visibility = View.VISIBLE

                }
                is Result.Error -> {
                    imageView.visibility = View.GONE
                    progressBar.visibility = View.GONE
                    textView.visibility = View.VISIBLE
                    textView.text = it.message
                    button.visibility = View.VISIBLE

                    button.setOnClickListener {

                    }
                }
                is Result.Success -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }

            }

        })

    }

}