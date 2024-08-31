package com.example.database

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var scity : EditText
    lateinit var btn_insert : Button
    lateinit var btn_update : Button
    lateinit var btn_clear : Button
    lateinit var rs : Cursor

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        scity = findViewById(R.id.city)
        btn_insert = findViewById(R.id.insert)
        btn_clear = findViewById(R.id.clear)

        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase
        Toast.makeText(applicationContext,"Crerated",Toast.LENGTH_LONG).show()
        rs = db.rawQuery("SELECT SID _id,SNAME,CITY FROM STUDENT",null)

        if(rs.moveToFirst()){
            name.setText(rs.getString(1))
            scity.setText(rs.getString(2))
        }

    }
}