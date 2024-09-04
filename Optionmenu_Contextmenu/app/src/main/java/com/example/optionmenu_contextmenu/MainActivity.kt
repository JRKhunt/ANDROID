package com.example.optionmenu_contextmenu

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textview)
        registerForContextMenu(tv)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(101, 1001, 1, "New Group")
        menu?.add(102, 1002, 2, "New Broadcast")
        menu?.add(103, 1003, 3, "Linked Device ")
        menu?.add(104, 1004, 4, "Payment")
        menu?.add(105, 1005, 5, "Setting")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1001 -> Toast.makeText(applicationContext, "NNew Group Clicked!!!", Toast.LENGTH_SHORT)
                .show()
            1002 -> Toast.makeText(
                applicationContext,
                "New Broadcast Clicked!!!",
                Toast.LENGTH_SHORT
            ).show()
            1003 -> tv.textSize = 40f
            1005 -> {
                startActivity(Intent(this, settingactivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

        menu?.setHeaderTitle("choose color")
        menu?.add(111,1111,1,"RED")
        menu?.add(112,1112,2,"BLUE")
        menu?.add(113,1113,3,"GREEN")
        menu?.add(114,1114,4,"YELLOW")
        menu?.add(114,1115,4,"CYAN")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            1111-> tv.setTextColor(Color.RED)
            1112-> tv.setTextColor(Color.BLUE)
            1113-> tv.setTextColor(Color.GREEN)
            1114-> tv.setTextColor(Color.YELLOW)
            1115-> tv.setTextColor(Color.CYAN)
        }
        return super.onContextItemSelected(item)
    }
}

