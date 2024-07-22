package com.restaurants.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.restaurants.R
import com.restaurants.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val intent = Intent(this, Otp_page::class.java)
            startActivity(intent)
        }

        binding.facebook.setOnClickListener {
            openUrl("https://www.facebook.com/")
        }
        binding.gmail.setOnClickListener {
            openUrl("https://www.facebook.com/")
        }
        binding.google.setOnClickListener {
            openUrl("https://www.facebook.com/")
        }

        binding.skip.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }


    }
    private fun openUrl(link: String) {
        val uri = Uri.parse(link)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
