package com.restaurants.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.restaurants.R
import com.restaurants.activity.Dashboard
import com.restaurants.activity.Otp_page
import com.restaurants.activity.YourOrders
import com.restaurants.databinding.FragmentOffersBinding
import com.restaurants.databinding.LeftMenuHeadderBinding

class Left_menu : Fragment() , NavigationView.OnNavigationItemSelectedListener{

    private lateinit var navigationView: NavigationView
    private lateinit var binding: LeftMenuHeadderBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var openMenuButton: Button
    private lateinit var closeButton: ImageView
    private lateinit var settingsIcon: ImageView
    private lateinit var userName: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_left_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        drawerLayout = view.findViewById(R.id.drawer_layout)
        navView = view.findViewById(R.id.nav_view)
        openMenuButton = view.findViewById(R.id.open_menu_button)

        // Find header views
        val headerView = navView.getHeaderView(0)
        closeButton = headerView.findViewById(R.id.close_button)
        settingsIcon = headerView.findViewById(R.id.settings_icon)
        userName = headerView.findViewById(R.id.user_name)

        // Set user name (you can dynamically set this)
        userName.text = "Mnoj"

        // Automatically open the drawer when the fragment is created
        drawerLayout.openDrawer(GravityCompat.START)

        // Open the drawer
        openMenuButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Close the drawer
        closeButton.setOnClickListener {
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        // Handle settings icon click
        settingsIcon.setOnClickListener {
            // Handle settings click
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            handleNavigationItemSelected(menuItem)
            true
        }
    }

    private fun handleNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_home -> {
                val homeFragment = Home()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.content_frame, homeFragment) // Replace with your fragment container id
                    .addToBackStack(null) // Optional: add to back stack
                    .commit()
            }
             R.id.nav_orders -> {
                val intent = Intent(requireContext(), YourOrders::class.java)
                startActivity(intent)
                drawerLayout.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.nav_favorites -> {
                // Handle Favorite Orders action
            }
            R.id.nav_top_rated -> {
                // Handle Top Rated Near You action
            }
            R.id.nav_address -> {
                // Handle Your Address action
            }
            R.id.nav_about_us -> {
                // Handle About Us action
            }
            R.id.nav_contact_us -> {
                // Handle Contact Us action
            }
            R.id.nav_send_feedback -> {
                // Handle Send Feedback action
            }
            R.id.nav_rate_us -> {
                // Handle Rate Us on the Play Store action
            }
            R.id.nav_terms_conditions -> {
                // Handle Terms & Conditions action
            }
            R.id.nav_privacy_policy -> {
                // Handle Privacy Policy action
            }
            R.id.nav_logout -> {
                // Handle Logout action
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        menuItem.isChecked = true // Set the selected item
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}

