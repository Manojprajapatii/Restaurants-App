package com.restaurants.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.restaurants.R
import com.restaurants.databinding.ActivityViewAllProductsBinding


class ViewAllProducts : AppCompatActivity() {

    private lateinit var binding: ActivityViewAllProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAllProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

        val button = findViewById<Button>(R.id.all)
        button.text = HtmlCompat.fromHtml("<u>All</u>", HtmlCompat.FROM_HTML_MODE_LEGACY)

    }
}
