package com.example.tweened_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import java.nio.file.Files.move

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var iv = findViewById<ImageView>(R.id.imageView)

        var b = findViewById<Button>(R.id.button)
        b.setOnClickListener{
            var an = AnimationUtils.loadAnimation(this,R.anim.spin)
            iv.startAnimation(an)
        }
        var b1 = findViewById<Button>(R.id.button1)
        b1.setOnClickListener{
            var an = AnimationUtils.loadAnimation(this,R.anim.zoom)
            iv.startAnimation(an)
        }
        var b2 = findViewById<Button>(R.id.button2)
        b2.setOnClickListener{
            var an = AnimationUtils.loadAnimation(this,R.anim.move)
            iv.startAnimation(an)
        }
        var b3 = findViewById<Button>(R.id.button3)
        b3.setOnClickListener{
            var an = AnimationUtils.loadAnimation(this,R.anim.blink)
            iv.startAnimation(an)
        }
    }
}