 package com.example.multiple.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.example.multiple.R
import com.example.multiple.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

 @AndroidEntryPoint
 class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel> ()

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button =findViewById(R.id.startButton)
        val textView1:TextView=findViewById(R.id.text1)
        val textView2: TextView =findViewById(R.id.text2)

        button.setOnClickListener {
            mainViewModel.getData()
        }
        mainViewModel.questionModel.observe(this, {
            it?.let {
                textView1.text = it.first
                textView2.text = it.second
            }
        }
        )
    }
}