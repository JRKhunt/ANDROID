package com.example.contactapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.SearchView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val cols = arrayOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    )

    private val NEW_CONTACT_REQUEST_CODE = 1
    private lateinit var adapter: SimpleCursorAdapter
    private lateinit var listView: ListView
    private lateinit var searchView: SearchView
    private var cursor: Cursor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_INSERT)
            intent.type = ContactsContract.RawContacts.CONTENT_TYPE
            startActivityForResult(intent, NEW_CONTACT_REQUEST_CODE)
        }

        listView = findViewById(R.id.Listview)
        searchView = findViewById(R.id.searchView)

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS), 111)
        } else {
            readContacts()
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterContacts(newText)
                return true
            }
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            readContacts()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NEW_CONTACT_REQUEST_CODE) {
            readContacts()
        }
    }

    override fun onResume() {
        super.onResume()
        readContacts()
    }

    @SuppressLint("Range")
    private fun readContacts() {
        cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )

        adapter = SimpleCursorAdapter(
            this,
            android.R.layout.simple_list_item_2,
            cursor,
            cols,
            intArrayOf(android.R.id.text1, android.R.id.text2),
            0
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            cursor?.moveToPosition(position)
            val phoneNumber = cursor?.getString(cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            phoneNumber?.let { makePhoneCall(it) }
        }
    }

    private fun filterContacts(query: String?) {
        val selection = "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?"
        val selectionArgs = arrayOf("%${query}%")
        cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols,
            selection,
            selectionArgs,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )
        adapter.changeCursor(cursor)
    }

    private fun makePhoneCall(phoneNumber: String) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 112)
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }
    }
}
