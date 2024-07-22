package com.restaurants.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.donation.adapter.CartAdapter
import com.restaurants.R
import com.restaurants.databinding.FragmentCartBinding
import com.restaurants.model.CartModel

class Cart : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var cartAdapter: CartAdapter
    private lateinit var dataList: ArrayList<CartModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the data list
        dataList = ArrayList()
        dataList.add(CartModel(R.drawable.chole, "Kadhai Chole", "Wooed Restaurants", "$15","X2"))
        dataList.add(CartModel(R.drawable.grapes, "Planet of the Grapes", "Tag line", "$180",""))
        dataList.add(CartModel(R.drawable.panner, "Shahi Paneer", "kanha restaurant", "$200","X2"))
        dataList.add(CartModel(R.drawable.chole, "Kadhai Chole", "Wooed Restaurants", "$15","X2"))
        dataList.add(CartModel(R.drawable.grapes, "Planet of the Grapes", "Tag line", "$180",""))
        dataList.add(CartModel(R.drawable.panner, "Shahi Paneer", "kanha restaurant", "$200","X2"))
        dataList.add(CartModel(R.drawable.chole, "Kadhai Chole", "Wooed Restaurants", "$15","X2"))
        dataList.add(CartModel(R.drawable.grapes, "Planet of the Grapes", "Tag line", "$180",""))
        dataList.add(CartModel(R.drawable.panner, "Shahi Paneer", "kanha restaurant", "$200","X2"))
        dataList.add(CartModel(R.drawable.chole, "Kadhai Chole", "Wooed Restaurants", "$15","X2"))
        dataList.add(CartModel(R.drawable.grapes, "Planet of the Grapes", "Tag line", "$180",""))
        dataList.add(CartModel(R.drawable.panner, "Shahi Paneer", "kanha restaurant", "$200","X2"))


        // Initialize the adapter
        cartAdapter = CartAdapter(dataList,this)

        // Setup the RecyclerView
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recycler.adapter = cartAdapter

        // Notify the adapter to refresh the data
        cartAdapter.notifyDataSetChanged()



    }
}
