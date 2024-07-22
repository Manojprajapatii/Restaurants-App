package com.restaurants.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.donation.adapter.OrdersAdapter
import com.restaurants.R
import com.restaurants.databinding.ActivityYourOrdersBinding
import com.restaurants.fragment.Left_menu
import com.restaurants.model.OrdersModel

class YourOrders : AppCompatActivity() {

    private lateinit var binding: ActivityYourOrdersBinding
    private lateinit var ordersAdapter: OrdersAdapter
    private lateinit var dataList: ArrayList<OrdersModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityYourOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button: ImageView = findViewById(R.id.leftarrow)
        button.setOnClickListener {
            openFragment(Left_menu())
        }


        // Initialize the data list
        dataList = ArrayList()
        dataList.add(OrdersModel(R.drawable.chole, "Kadhai Chole", "Wooed Restaurants", "$15"))
        dataList.add(OrdersModel(R.drawable.grapes, "Planet of the Grapes", "Tag line", "$180"))

        // Initialize the adapter
        ordersAdapter = OrdersAdapter(dataList)

        // Setup the RecyclerView
        binding.recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recycler.adapter = ordersAdapter
    }

    fun openFragment(fragment: Left_menu) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerLeftMenu, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}
