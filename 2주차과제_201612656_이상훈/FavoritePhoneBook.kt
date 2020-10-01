package com.example.week2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FavoritePhoneBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_phone_book)

        val fatherButton= findViewById<Button>(R.id.fatherButton)
        val motherButton = findViewById<Button>(R.id.motherButton)
        val professorButton = findViewById<Button>(R.id.professorButton)

        fatherButton.setOnClickListener {
            toActivityByUri("tel:010-0000-0000")
        }

        motherButton.setOnClickListener {
            toActivityByUri("tel:010-0000-0000")
        }

        professorButton.setOnClickListener {
            toActivityByUri("tel:010-0000-0000")
        }
    }

    private fun toActivityByUri(url: String){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
}