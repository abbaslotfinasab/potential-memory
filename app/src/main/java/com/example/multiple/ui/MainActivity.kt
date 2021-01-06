 package com.example.multiple.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multiple.R
import com.example.multiple.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

 @AndroidEntryPoint
 class MainActivity : AppCompatActivity() {

     @Inject lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            viewModel.getData()
        }
        viewModel.questionModel.observe(this, {
            it?.let {
                text1.text = it.first
                text2.text = it.secend
            }
        }
        )
    }
}