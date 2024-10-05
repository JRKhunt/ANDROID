package com.example.databasepractice

import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var ed_sname : EditText
    lateinit var ed_sem : EditText
    lateinit var btn_insert : Button
    lateinit var btn_clear : Button
    lateinit var rs : Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ed_sname = findViewById(R.id.ed_sname)
        ed_sem = findViewById(R.id.ed_sem)
        btn_insert = findViewById(R.id.Btn_insert)
        btn_clear = findViewById(R.id.Btn_clear)

        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase
        Toast.makeText(applicationContext, "DB and TABLE created", Toast.LENGTH_SHORT).show()
        rs = db.rawQuery("SELECT S _id, SNAME, SEM from STUDENT",null)

        if(rs.moveToFirst()){
            ed_sname.setText(rs.getString(1))
            ed_sem.setText(rs.getString(2))
        }

        btn_insert.setOnClickListener{
            var cv = ContentValues()
            cv.put("SNAME",ed_sname.text.toString())
            cv.put("SEM",ed_sem.text.toString())
            db.insert("STUDENT",null,cv)
            showmessage("RECORD INSERTED SUCESSFULLY")
        }

        btn_clear.setOnClickListener{
            clear()
        }
    }

    private fun showmessage(s: String) {
        AlertDialog.Builder(this)
            .setTitle("SUCESS!!!")
            .setMessage(s)
            .setPositiveButton("OK",DialogInterface.OnClickListener{dialogInterface, i ->
                if(rs.moveToFirst()){
                    ed_sname.setText(rs.getString(1))
                    ed_sem.setText(rs.getString(2))
                }else{
                    Toast.makeText(applicationContext, "Data Not Found", Toast.LENGTH_SHORT).show()
                }
            }).show()
    }
    private fun clear() {
        ed_sname.setText("")
        ed_sem.setText("")
        ed_sname.requestFocus() }
}