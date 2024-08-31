package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var btnregister : Button = findViewById(R.id.btnregister)

        btnregister.setOnClickListener {
            var i = Intent(this,Login::class.java)
            startActivity(i)
        }
    }
}