package com.restaurants.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.donation.adapter.OrdersAdapter
import com.restaurants.R
import com.restaurants.databinding.ActivityYourOrdersBinding
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

        // Initialize the data list
        dataList = ArrayList()
        dataList.add(OrdersModel(R.drawable.chole, "Kadhai Chole", "Wooed Restaurants", "$15"))
        dataList.add(OrdersModel(R.drawable.grapes, "Planet of the Grapes", "Tag line", "$180"))

        // Initialize the adapter
        ordersAdapter = OrdersAdapter(dataList)

        // Setup the RecyclerView
        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recycler.adapter = ordersAdapter
    }
}
