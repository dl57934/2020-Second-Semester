package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.title = "즐겨 찾기"
        setContentView(R.layout.activity_main)

        val favoriteTel = findViewById<Button>(R.id.FavoriteTel)
        val favoriteSite = findViewById<Button>(R.id.FavoriteSite)

        favoriteTel.setOnClickListener {
            startActivity(toAnotherActivity(FavoritePhoneBook()))
        }

        favoriteSite.setOnClickListener {
            startActivity(toAnotherActivity(FavoriteSiteBook()))
        }
    }



    private fun toAnotherActivity(app : AppCompatActivity) : Intent{
        return Intent(this, app::class.java)
    }
}