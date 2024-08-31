package com.example.task3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var vdo:VideoView=findViewById(R.id.videoView)
        var vid:String="android.resource://"+packageName+"/"+R.raw.login

        var videoUri = Uri.parse(vid)
        vdo.setVideoURI(videoUri)
        vdo.start()

        vdo.setOnCompletionListener {
            var i= Intent(this,register::class.java)
            startActivity(i);
        }
    }
}