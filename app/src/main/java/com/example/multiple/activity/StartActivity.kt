package com.example.multiple.activity

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.entity.Result
import com.example.multiple.R
import com.example.multiple.viewmodel.MainViewModel

class StartActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var textView1:TextView
    private lateinit var textView2:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        textView1 = findViewById(R.id.text1)
        textView2 = findViewById(R.id.text2)

        start()

    }


    private fun start() {

        mainViewModel.questionModel.observe(this, {
            if (it is Result.Success) {
                val handler = Handler()
                val n = 0
                val m = 4
                for (i in 1..20) {

                    for (j in n ..m){
                        handler.postDelayed({
                            textView1.text = it.data[j].first
                            textView2.text = it.data[j].second
                        },2000)
                    }

                    val r = (n..m).random()

                    if (ask(r)){

                        n+5
                        m+5
                    }

                    else break
                }
            }
        }
        )
    }

    private  fun ask(number: Int): Boolean {

        mainViewModel.questionModel.observe(this, {

            if (it is Result.Success) {

                if (number%2==0)
                    it.data[number].second
                else
                    it.data[number].first

            }
        }
        )
        return true
    }

}