package com.example.redio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rg : RadioGroup = findViewById(R.id.radiogroup)
        var tv2 : TextView = findViewById(R.id.textView)
        var resetbtn : Button = findViewById(R.id.button)

        rg.setOnCheckedChangeListener{radiogroup, i ->
            var rb = findViewById<RadioButton>(i)
            if(rb!=null){
                tv2.setText(rb.text)
            }
        }
        resetbtn.setOnClickListener{
            rg.clearCheck()
            tv2.setText("select your option")
        }


        var chbox1 : CheckBox = findViewById(R.id.checkBox)
        var chbox2 : CheckBox = findViewById(R.id.checkBox1)
        var chbox3 : CheckBox = findViewById(R.id.checkBox2)
        var chbox4 : CheckBox = findViewById(R.id.checkBox3)

        var txt : TextView = findViewById(R.id.textView2)

        chbox1.setOnClickListener{
           var str = "${chbox1.text} :  ${chbox1.isChecked}\n ${chbox2.text}: ${chbox2.isChecked} \n ${chbox3.text}: ${chbox3.isChecked}\n${chbox4.text}: ${chbox4.isChecked}"
            txt.setText(str)
        }
        chbox2.setOnClickListener{
            var str = "${chbox1.text}: ${chbox1.isChecked}\n ${chbox2.text} : ${chbox2.isChecked}\n ${chbox3.text}: ${chbox3.isChecked}\n${chbox4.text}: ${chbox4.isChecked}"
            txt.setText(str)
        }
        chbox3.setOnClickListener{
            var str = "${chbox1.text}: ${chbox1.isChecked}\n ${chbox2.text} : ${chbox2.isChecked}\n ${chbox3.text}: ${chbox3.isChecked}\n ${chbox4.text}: ${chbox4.isChecked}"
            txt.setText(str)
        }
        chbox4.setOnClickListener{
            var str = "${chbox1.text}: ${chbox1.isChecked}\n ${chbox2.text} : ${chbox2.isChecked}\n ${chbox3.text}: ${chbox3.isChecked}\n ${chbox4.text}: ${chbox4.isChecked}"
            txt.setText(str)
        }

    }
}