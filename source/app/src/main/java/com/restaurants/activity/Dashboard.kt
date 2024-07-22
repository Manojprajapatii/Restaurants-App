package com.restaurants.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.restaurants.R
import com.restaurants.fragment.Cart
import com.restaurants.fragment.Home
import com.restaurants.fragment.Left_menu
import com.restaurants.fragment.Offers
import com.restaurants.fragment.Profile

class Dashboard : AppCompatActivity() {

    private val leftMenu = 1
    private val offer = 2
    private val home = 3
    private val profile = 4
    private val cart = 5

    @SuppressLint("MissingInflatedId", "LocalSuppress")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val bottomNavigation: MeowBottomNavigation = findViewById(R.id.meowBottomNavigation)
        bottomNavigation.add(MeowBottomNavigation.Model(leftMenu, R.drawable.left_menu))
        bottomNavigation.add(MeowBottomNavigation.Model(offer, R.drawable.offers))
        bottomNavigation.add(MeowBottomNavigation.Model(home, R.drawable.home2))
        bottomNavigation.add(MeowBottomNavigation.Model(profile, R.drawable.profile))
        bottomNavigation.add(MeowBottomNavigation.Model(cart, R.drawable.cart))

        bottomNavigation.setOnShowListener { model ->
            val name = when (model.id) {
                leftMenu -> {
                    openFragment(Left_menu())
                    "Left Menu"
                }
                offer -> {
                    openFragment(Offers())
                    "Offer"
                }
                home -> {
                    openFragment(Home())
                    "Home"
                }
                profile -> {
                    openFragment(Profile())
                    "Profile"
                }
                cart -> {
                    openFragment(Cart())
                    "Cart"
                }
                else -> ""
            }

            showToast(name)


            bottomNavigation.setCount(cart, "5")
        }


        bottomNavigation.show(home)
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(this@Dashboard, message, Toast.LENGTH_SHORT)
        toast.show()


        Handler(Looper.getMainLooper()).postDelayed({
            toast.cancel()
        }, 1000)
    }
}
