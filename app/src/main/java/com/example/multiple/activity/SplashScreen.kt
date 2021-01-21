package com.example.multiple.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import com.example.multiple.R
import com.example.multiple.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException


@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private val mainViewModel:MainViewModel by viewModels()

    private lateinit var progressBar:ProgressBar
    private lateinit var imageView:ImageView
    private lateinit var textView:TextView
    private lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)
        progressBar = findViewById(R.id.progressbar)
        imageView = findViewById(R.id.image_view)
        textView = findViewById(R.id.textView1)
        button = findViewById(R.id.button)

        textView.visibility = View.GONE
        button.isActivated = false
        button.visibility = View.GONE

        try {

            mainViewModel.getData()

        }
        catch (e : IOException){

            e.message?.let { onError(it) }
        }

        if(textView.visibility==View.GONE)

            onSuccess()

    }

    private fun onError(message:String){

        progressBar.visibility = View.GONE
        imageView.visibility = View.GONE
        textView.visibility = View.VISIBLE
        button.visibility = View.VISIBLE
        button.isActivated = true
        textView.text = message

    }

    private fun onSuccess (){

        intent = Intent(this,MainActivity::class.java)
        startActivity(intent)


    }

}