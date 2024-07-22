package com.restaurants.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.restaurants.R

@Suppress("DEPRECATION")
class SpalshActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Use Handler with the main Looper
        Handler(Looper.getMainLooper()).postDelayed({
            val mainIntent = Intent(this@SpalshActivity, Login::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}
