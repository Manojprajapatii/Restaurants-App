package com.restaurants.activity

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.restaurants.R
class Otp_page : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_page)


        val pinView = findViewById<com.chaos.view.PinView>(R.id.firstPinView)

        pinView.post {
            pinView.requestFocus()
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(pinView, InputMethodManager.SHOW_IMPLICIT)
        }



        val sendOtp = findViewById<Button>(R.id.btn)
        sendOtp.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }

}