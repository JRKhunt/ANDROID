package com.example.relativelayoutbuttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lamp : Button = findViewById(R.id.toggleButton)
        var imagebtn : ImageButton = findViewById(R.id.imageButton)
        var imgview : ImageView = findViewById(R.id.imageView)
        var floatingActionButton : Button = findViewById(R.id.floatingActionButton)

        lamp.setOnClickListener {
            if(lamp.text.equals("OFF")){
                imgview.setImageResource(R.drawable.offfan)
            }else {
                imgview.setImageResource(R.drawable.onfan)
            }
        }

        imagebtn.setOnClickListener {
            Toast.makeText(applicationContext,"Atimya logo",Toast.LENGTH_LONG).show()
        }

        floatingActionButton.setOnClickListener {

        }
    }
}