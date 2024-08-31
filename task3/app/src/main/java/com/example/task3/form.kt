package com.example.task3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        var btn:Button=findViewById(R.id.button3)
        var nam:EditText=findViewById(R.id.name)
        var eml:EditText=findViewById(R.id.email)
        var phones:EditText=findViewById(R.id.number)
        var pass:EditText=findViewById(R.id.password)
        var cpass:EditText=findViewById(R.id.confirm)
        var chk:CheckBox=findViewById(R.id.checkBox)



        var sp = application.getSharedPreferences("logindata",Context.MODE_PRIVATE)
        btn.setOnClickListener {

            var usn=nam.text.toString()
            var email=eml.text.toString().trim()
            var phonss=phones.text.toString().trim()
            var pas=pass.text.toString().trim()
            var cpa=cpass.text.toString().trim()
            var ck=chk.text.toString().trim()

               if(usn.isEmpty())
               {
                  nam.error="Name field required !"
                   return@setOnClickListener
               }
               else if(email.isEmpty())
                {
                    eml.error="Email field required !"
                    return@setOnClickListener
                }
               else if(phonss.isEmpty())
               {
                   phones.error="Phones field required !"
                   return@setOnClickListener
               }
               else if(pas.isEmpty())
               {
                   pass.error="Password field required !"
                   return@setOnClickListener
               }
               else if(cpa.isEmpty())
               {
                   cpass.error="Cofirm password field required !"
                   return@setOnClickListener
               }
                else if(!pas.equals(cpa))
               {
                    pass.error="password not matches"
                   return@setOnClickListener
               }
               else if(!chk.isChecked)
               {
                   chk.error="Accept the conditions"
                   return@setOnClickListener
               }
               else{
                var i = Intent(this,view::class.java)
                   startActivity(i);
               }

        }
    }
}