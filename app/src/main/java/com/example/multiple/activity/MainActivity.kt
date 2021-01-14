 package com.example.multiple.activity


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.multiple.R
import com.example.multiple.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

 @AndroidEntryPoint
 class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel> ()

     @RequiresApi(Build.VERSION_CODES.M)
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         val button: Button = findViewById(R.id.startButton)
         button.setOnClickListener {

             mainViewModel.getData()

         }

         mainViewModel.questionModel.observe(this, {
             it?.let {
                 Toast.makeText(
                     this,
                     "${it.first}in persian is ${it.second}",
                     Toast.LENGTH_LONG
                 ).show()

             }
         })
     }
}