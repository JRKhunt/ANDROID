package com.example.filehandling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var multiline  : EditText = findViewById(R.id.editTextTextMultiLine)
        var write : Button = findViewById(R.id.button)
        var read : Button = findViewById(R.id.button2)

        var builder = Alert
    }
}