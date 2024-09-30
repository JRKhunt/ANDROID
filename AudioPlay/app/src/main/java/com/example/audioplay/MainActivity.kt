package com.example.audioplay

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btn : Button
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var mp : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btnoffline)
        btn1 = findViewById(R.id.btnoffline1)
        btn2 = findViewById(R.id.btnonline)
        btn3 = findViewById(R.id.btnonline1)

//        btn.setOnClickListener{
//            mp = MediaPlayer.create(this,R.raw.)
//            mp.start()
//        }
//
//        btn1.setOnClickListener {
//            mp.stop()
//        }

        btn2.setOnClickListener{
            mp = MediaPlayer()
            mp.setDataSource(this, Uri.parse("https://www.pagalworld.com.sb/files/download/type/320/id/71764/1.mp3"))
            mp.prepare()
            mp.start()
        }

        btn3.setOnClickListener {
            mp.stop()
        }
    }
}