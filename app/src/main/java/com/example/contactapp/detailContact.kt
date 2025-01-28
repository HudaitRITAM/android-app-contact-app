package com.example.contactapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class detailContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_contact)

        val userprofile = findViewById<ImageView>(R.id.userprofileimage)
        val userName = findViewById<TextView>(R.id.userName)
        val usercontactnumber = findViewById<TextView>(R.id.contactNumber)


        val userimage = intent.getIntExtra("profileImage",R.drawable.image1)
        val username = intent.getStringExtra("name")
        val usernumber = intent.getStringExtra("number")

        userprofile.setImageResource(userimage)
        userName.text = username
        usercontactnumber.text = usernumber


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}