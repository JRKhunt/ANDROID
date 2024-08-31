package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn:Button = findViewById(R.id.button5)
        btn.setOnClickListener {
            var i = Intent(this,Second_Activity::class.java)
            startActivity(i)
        }
    }
}