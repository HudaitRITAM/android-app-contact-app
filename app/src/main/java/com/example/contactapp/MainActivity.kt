package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var userArrayList: ArrayList<UserData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val contactProfileImage = intArrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10,
        )

        val contactName = arrayOf(
            "Heisenberg",
            "Jesse Pinkman",
            "Hank Schrader",
            "Walter White Jr.",
            "Gus Fring",
            "Saul Goodman",
            "Mike Ehrmantraut",
            "Howard Hamlin",
            "Chuck McGill",
            "Lalo Salamanca"
        )
        val contactNumber = arrayOf(
            "83232523756",
            "94693459835",
            "09328592393",
            "83258233888",
            "82347325725",
            "89852835827",
            "28984838238",
            "87238783283",
            "35783487534",
            "96693u83458"
        )

        userArrayList = ArrayList()
        for (position in contactName.indices) {
            val contact = UserData(
                contactProfileImage[position],
                contactName[position],
                contactNumber[position])
                userArrayList.add(contact)

        }

        val listView = findViewById<ListView>(R.id.listview)
        listView.adapter = ContactAdapter(this,userArrayList)
        listView.isClickable = true
        listView.setOnItemClickListener { parent, view, position, id ->
            val profile = contactProfileImage[position]
            val name = contactName[position]
            val number = contactNumber[position]
            val intent = Intent(this,detailContact::class.java)
            intent.putExtra("profileImage",profile)
            intent.putExtra("name",name)
            intent.putExtra("number",number)
            startActivity(intent)

        }



//        val contactList = listOf(
//            contactModel(R.drawable.image1,"Heisenberg"),
//            contactModel(R.drawable.image2,"Jesse Pinkman"),
//            contactModel(R.drawable.image3,"Hank Schrader"),
//            contactModel(R.drawable.image4,"Walter White Jr."),
//            contactModel(R.drawable.image5,"Gus Fring"),
//            contactModel(R.drawable.image6,"Saul Goodman"),
//            contactModel(R.drawable.image7,"Mike Ehrmantraut"),
//            contactModel(R.drawable.image8,"Howard Hamlin"),
//            contactModel(R.drawable.image9,"Chuck McGill"),
//            contactModel(R.drawable.image10,"Lalo Salamanca"),
//
//        )
//        val contactName = contactList.map { it.name }
//        val listView:ListView = findViewById(R.id.listview)
//        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,contactName)
//        listView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

data class contactModel(val image: Int, val name: String)