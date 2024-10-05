package com.example.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        val imageView = findViewById<ImageView>(R.id.imageView)
        val btnPlayPause = findViewById<Button>(R.id.btnPlayPause)

        // Initialize MediaPlayer with a music file
        mediaPlayer = MediaPlayer.create(this, R.raw.aajkiraat)

        // Play/Pause button click listener
        btnPlayPause.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.pause()
            } else {
                mediaPlayer.start()
            }
            isPlaying = !isPlaying
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release MediaPlayer resources when the activity is destroyed
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.release()
    }
}
