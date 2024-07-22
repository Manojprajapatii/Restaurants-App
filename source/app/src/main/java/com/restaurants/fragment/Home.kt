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
import com.restaurants.R
import com.restaurants.activity.MapsActivity
import com.restaurants.activity.Notification
import com.restaurants.adapter.HomeAdapter
import com.restaurants.databinding.FragmentHomeBinding
import com.restaurants.model.HomeModel
import com.restaurants.model.ParcelableLatLng

@Suppress("DEPRECATION")
class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mapsActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
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

        // Set OnClickListener for the notification button
        binding.notificationBtn.setOnClickListener {
            val intent = Intent(requireContext(), Notification::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for the search icon
        binding.card1.setOnClickListener {
            val intent = Intent(requireContext(), MapsActivity::class.java)
            mapsActivityResultLauncher.launch(intent)
        }

        // Set up RecyclerView
        val dataList = arrayListOf(
            HomeModel(R.drawable.chole, "Planet of the Grapes", "Tag line", "View All Products"),
            HomeModel(R.drawable.chole, "Planet of the Grapes", "Tag line", "View All Products"),
            HomeModel(R.drawable.chole, "Planet of the Grapes", "Tag line", "View All Products"),
            HomeModel(R.drawable.chole, "Planet of the Grapes", "Tag line", "View All Products"),
            HomeModel(R.drawable.chole, "Planet of the Grapes", "Tag line", "View All Products"),
            HomeModel(R.drawable.chole, "Planet of the Grapes", "Tag line", "View All Products"),
            HomeModel(R.drawable.chole, "Planet of the Grapes", "Tag line", "View All Products"),
            HomeModel(R.drawable.chole, "Planet of the Grapes", "Tag line", "View All Products"),

        )
        val homeAdapter = HomeAdapter(dataList, requireContext())
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = homeAdapter
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.setItemViewCacheSize(20)
        binding.recyclerView.isDrawingCacheEnabled = true
        binding.recyclerView.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
        binding.recyclerView.isNestedScrollingEnabled = false
    }
}
