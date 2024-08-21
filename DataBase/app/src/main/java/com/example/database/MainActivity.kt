package com.example.database

import android.content.ContentValues
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var ed_Sname : EditText
    lateinit var ed_Sem : EditText
    lateinit var btn_Insert : Button
    lateinit var btn_Clear : Button
    lateinit var btn_Update : Button
    lateinit var btn_Delete : Button
    lateinit var btn_next : Button
    lateinit var btn_previous : Button
    lateinit var btn_first : Button
    lateinit var btn_last : Button
    lateinit var btn_showAll :Button
    lateinit var searchView: SearchView
    lateinit var listview : ListView
    lateinit var  rs : Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed_Sname = findViewById(R.id.ed_Sname)
        ed_Sem = findViewById(R.id.ed_Sem)
        btn_Insert = findViewById(R.id.btn_Insert)
        btn_Clear = findViewById(R.id.btn_Clear)
        btn_Update = findViewById(R.id.btn_Update)
        btn_Delete = findViewById(R.id.btn_Detele)
        btn_next = findViewById(R.id.btn_Next)
        btn_previous = findViewById(R.id.btn_Previous)
        btn_first = findViewById(R.id.btn_First)
        btn_last = findViewById(R.id.btn_Last)
        btn_showAll = findViewById(R.id.showall)
        searchView = findViewById(R.id.searchView)
        listview = findViewById(R.id.listView)


        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase
        Toast.makeText(applicationContext, "database and table created", Toast.LENGTH_SHORT).show()
        rs = db.rawQuery("Select Sid _id , Sname , Sem FROM Student ", null)

        if (rs.moveToFirst()) {
            ed_Sname.setText(rs.getString(1))
            ed_Sem.setText(rs.getString(2))
        }


        btn_Insert.setOnClickListener {
            if(ed_Sname.text.toString().length <= 0){
                Toast.makeText(applicationContext, "Please Enter A Data!!!", Toast.LENGTH_SHORT).show()
            }else{
                var cv = ContentValues()
                cv.put("Sname", ed_Sname.text.toString())
                cv.put("Sem", ed_Sem.text.toString())
                db.insert("Student", null, cv)
                rs = db.rawQuery("Select Sid _id , Sname , Sem FROM Student ", null)
                showMessage("Record Inserted Successfully")
            }
        }

        btn_Update.setOnClickListener {
            if(ed_Sname.text.toString().length <= 0){
                Toast.makeText(applicationContext, "Please Enter Update Data!!!", Toast.LENGTH_SHORT).show()
            }else{var cv = ContentValues()
                cv.put("Sname", ed_Sname.text.toString())
                cv.put("Sem", ed_Sem.text.toString())
                db.update("Student", cv, "Sid = ?", arrayOf(rs.getString(0)))
                rs = db.rawQuery("Select Sid _id , Sname , Sem FROM Student ", null)
                showMessage("Record Updated Successfully")
                clear()
            }
        }

        btn_Delete.setOnClickListener {
            db.delete("Student", "Sid = ?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("Select Sid _id , Sname , Sem FROM Student ", null)
            showMessage("Record Deleted Successfully")
            clear()
        }

        btn_Clear.setOnClickListener {
            clear()
        }

        btn_next.setOnClickListener {
            if(rs.moveToNext()){
                ed_Sname.setText(rs.getString(1))
                ed_Sem.setText(rs.getString(2))
            }else if (rs.moveToFirst()){
                ed_Sname.setText(rs.getString(1))
                ed_Sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext, "Data Not Found!!!", Toast.LENGTH_SHORT).show()
            }
        }

        btn_previous.setOnClickListener {
            if(rs.moveToPrevious()){
                ed_Sname.setText(rs.getString(1))
                ed_Sem.setText(rs.getString(2))
            }else if (rs.moveToLast()){
                ed_Sname.setText(rs.getString(1))
                ed_Sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext, "Data Not Found!!!", Toast.LENGTH_SHORT).show()
            }
        }

        btn_first.setOnClickListener {
            if(rs.moveToFirst()){
                ed_Sname.setText(rs.getString(1))
                ed_Sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext, "Data Not Found!!!", Toast.LENGTH_SHORT).show()
            }
        }
        btn_last.setOnClickListener {
            if(rs.moveToLast()){
                ed_Sname.setText(rs.getString(1))
                ed_Sem.setText(rs.getString(2))
            }else{
                Toast.makeText(applicationContext, "Data Not Found!!!", Toast.LENGTH_SHORT).show()
            }
        }
        btn_showAll.setOnClickListener {
            var adapter = SimpleCursorAdapter(applicationContext,R.layout.my_layout,rs,
            arrayOf("Sname","Sem"),
            intArrayOf(R.id.textname, R.id.textsem))
            listview.adapter = adapter
        }
    }

    private fun clear() {
        ed_Sname.setText("")
        ed_Sem.setText("")
        ed_Sname.requestFocus()
    }

    private fun showMessage(s: String) {
        AlertDialog.Builder(this)
            .setTitle("Success!!!")
            .setMessage(s)
            .setPositiveButton("Ok", {dialogInterface, i->
                if(rs.moveToFirst()){
                    ed_Sname.setText(rs.getString(1))
                    ed_Sem.setText(rs.getString(2))
                }else{
                    Toast.makeText(applicationContext, "Data not Found", Toast.LENGTH_SHORT).show()
                }
            }).show()
    }
}
