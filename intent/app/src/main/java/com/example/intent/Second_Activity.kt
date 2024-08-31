package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
class Second_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var btn : Button = findViewById(R.id.button5)
        btn.setOnClickListener {
            var uri = Uri.parse("https://www.google.com")
            var i = Intent(Intent.ACTION_VIEW,uri)
            startActivity(i)

            var text : EditText = findViewById(R.id.editTextTextPersonName3)
            var btn_form : Button = findViewById(R.id.button2)
            btn_form.setOnClickListener {
                var uri = Uri.parse("tel:"+text.text.toString())
                var i = Intent(Intent.ACTION_DIAL,uri)
                startActivity(i)

        }
    }
}