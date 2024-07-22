package com.restaurants.activity


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.restaurants.R
import com.restaurants.adapter.NotificationAdapter
import com.restaurants.databinding.ActivityNotificationBinding
import com.restaurants.fragment.Left_menu
import com.restaurants.fragment.Offers
import com.restaurants.model.NotificationModel


@Suppress("DEPRECATION")
class Notification : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var notificationList: ArrayList<NotificationModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout for this activity
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        imageView = findViewById(R.id.back)
//        imageView.setOnClickListener {
//            navigateToTargetFragment()
//        }


        val myImageView = findViewById<ImageView>(com.restaurants.R.id.back)
        myImageView.setOnClickListener { // Replace the current fragment with the Left_menu fragment
            supportFragmentManager.beginTransaction()
                .replace(com.restaurants.R.id.fragment_container, Left_menu())
                .addToBackStack(null)
                .commit()
        }

        // Set click listener for the back button
//        binding.back.setOnClickListener {
//            val intent = Intent(this, Dashboard::class.java)
//            startActivity(intent)
//        }

        // Set click listener for arrowLeft
        binding.arrowLeft.setOnClickListener {
            Log.d("NotificationActivity", "Arrow Left clicked")
            replaceFragment(Offers())
        }

        // Initialize the data list
        notificationList = arrayListOf(
            NotificationModel(com.restaurants.R.drawable.notification, "Lorem ipsum", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi fugiat quidem aut et dignissimos", "10:15 AM", isHighlighted = true),
            NotificationModel(com.restaurants.R.drawable.notification, "Lorem ipsum", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi fugiat quidem aut et dignissimos", "10:15 AM", isHighlighted = true),
            NotificationModel(com.restaurants.R.drawable.notification, "Lorem ipsum", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi fugiat quidem aut et dignissimos", "10:15 AM"),
            NotificationModel(com.restaurants.R.drawable.notification, "Lorem ipsum", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi fugiat quidem aut et dignissimos", "10:15 AM"),
            NotificationModel(com.restaurants.R.drawable.notification, "Lorem ipsum", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Modi fugiat quidem aut et dignissimos", "10:15 AM"),
            // Add more items as needed
        )

        // Initialize the adapter
        notificationAdapter = NotificationAdapter(this, notificationList)

        // Setup the RecyclerView
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = notificationAdapter

        // Enable optimizations
        binding.recycler.setHasFixedSize(true)
        binding.recycler.setItemViewCacheSize(20)
        binding.recycler.isDrawingCacheEnabled = true
        binding.recycler.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
        binding.recycler.isNestedScrollingEnabled = false
    }



//    private fun navigateToTargetFragment() {
//        val targetFragment = Left_menu()
//
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.content_frame, targetFragment) // Replace layout
//        // Alternatively, use transaction.add(R.id.fragment_container_layout, targetFragment) to add the fragment
//        transaction.addToBackStack(null) // Add to back stack for navigation (optional)
//        transaction.commit()
//    }


    private fun replaceFragment(fragment: Fragment) {
        Log.d("NotificationActivity", "Replacing fragment with ${fragment::class.java.simpleName}")
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(com.restaurants.R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
