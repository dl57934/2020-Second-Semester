package com.example.week2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FavoriteSiteBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_site_book)

        val daumButton= findViewById<Button>(R.id.daum)
        val naverButton = findViewById<Button>(R.id.naverButton)
        val pukyongButton = findViewById<Button>(R.id.pukyongButton)

        daumButton.setOnClickListener {
            toActivityByUri("http://daum.net")
        }

        naverButton.setOnClickListener {
            toActivityByUri("http://naver.com")
        }

        pukyongButton.setOnClickListener {
            toActivityByUri("http://www.pknu.ac.kr/")
        }
    }

    private fun toActivityByUri(url: String){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
}