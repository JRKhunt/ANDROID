package com.example.task3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var btn:Button=findViewById(R.id.button)
        var reg:Button=findViewById(R.id.button2)

        btn.setOnClickListener {
            Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show()
        }

        reg.setOnClickListener {
            var i=Intent(this,form::class.java)
            startActivity(i)
        }
    }
}