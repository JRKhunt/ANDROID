package com.example.fremlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var pb : ProgressBar = findViewById(R.id.progressBar)
        var tb : EditText = findViewById(R.id.editTextNumberSigned)

        Thread (Runnable{
            var c = 0
            var perc = 0
            while (c <= 100){
                Thread.sleep(100)
                c++
                pb.setProgress(c)
                perc++
                tb = perc
            }
        }).start()
    }
}