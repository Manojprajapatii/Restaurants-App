package com.restaurants.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.donation.adapter.OfferAdapter
import com.restaurants.databinding.FragmentOffersBinding
import com.restaurants.model.OfferModel
import com.restaurants.R
import com.restaurants.activity.MapsActivity
import com.restaurants.activity.Notification
import com.restaurants.model.ParcelableLatLng

class Offers : Fragment() {

    private lateinit var binding: FragmentOffersBinding
    private lateinit var offerAdapter: OfferAdapter
    private lateinit var dataList: ArrayList<OfferModel>
    private lateinit var colorList: List<Int>
    private lateinit var mapsActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOffersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the ActivityResultLauncher
        mapsActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data = result.data
                    val selectedLocation = data?.getParcelableExtra<ParcelableLatLng>(MapsActivity.LOCATION_EXTRA)
                    val locationName = data?.getStringExtra(MapsActivity.LOCATION_NAME_EXTRA)
                    if (selectedLocation != null && locationName != null) {
                        binding.location.text = locationName
                    }
                }
            }
        )

        dataList = ArrayList()
        dataList.add(OfferModel(R.drawable.chole, "Chole", "Flat 50% OFF", "On Food Order"))
        dataList.add(OfferModel(R.drawable.panner, "Chilli Paneer", "रु 75 OFF", "ON ORDER ABOVE रु 499"))
        dataList.add(OfferModel(R.drawable.offer_img3, "Tacos", "Flat 30% OFF", "On Food Order"))
        dataList.add(OfferModel(R.drawable.offer_img2, "Paneer Lababdar", "रु 50 OFF", "ON ORDER ABOVE रु 699"))
        dataList.add(OfferModel(R.drawable.chole, "Chole", "Flat 50% OFF", "On Food Order"))
        dataList.add(OfferModel(R.drawable.panner, "Chilli Paneer", "रु 75 OFF", "ON ORDER ABOVE रु 499"))
        dataList.add(OfferModel(R.drawable.offer_img3, "Tacos", "Flat 30% OFF", "On Food Order"))
        dataList.add(OfferModel(R.drawable.offer_img2, "Paneer Lababdar", "रु 50 OFF", "ON ORDER ABOVE रु 699"))
        dataList.add(OfferModel(R.drawable.chole, "Chole", "Flat 50% OFF", "On Food Order"))
        dataList.add(OfferModel(R.drawable.panner, "Chilli Paneer", "रु 75 OFF", "ON ORDER ABOVE रु 499"))
        dataList.add(OfferModel(R.drawable.offer_img3, "Tacos", "Flat 30% OFF", "On Food Order"))

        // Define the list of colors
        colorList = listOf(
            R.color.colorPrimary,
            R.color.colorAccent,
            R.color.colorAccent1,
            R.color.colorPrimaryDark,
            R.color.colorAccentDark
        )

        offerAdapter = OfferAdapter(dataList, colorList, this)
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = offerAdapter

        // Set OnClickListener for the notification button
        binding.notificationBtn.setOnClickListener {
            val intent = Intent(requireContext(), Notification::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for the card
        binding.card1.setOnClickListener {
            val intent = Intent(requireContext(), MapsActivity::class.java)
            mapsActivityResultLauncher.launch(intent)
        }
    }
}
