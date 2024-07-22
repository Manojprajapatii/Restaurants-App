package com.restaurants.activity

import android.app.Activity
import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.restaurants.R
import com.restaurants.model.ParcelableLatLng
import java.util.Locale

@Suppress("DEPRECATION")
class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val toggleButton: FloatingActionButton = findViewById(R.id.btnToggle)
        toggleButton.setOnClickListener { view ->
            showPopup(view)
        }
    }

    private fun showPopup(view: View) {
        val popup = PopupMenu(this, view)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_map_type, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_normal -> mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                R.id.action_satellite -> mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                R.id.action_terrain -> mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
            }
            true
        }
        popup.show()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker and move the camera
        val sydney = LatLng(26.79945957446643, 75.81756721816991)
        mMap.addMarker(MarkerOptions().position(sydney).title("Sharma Sweets Pratap Nager Jaipur"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        // Set up a map click listener
        mMap.setOnMapClickListener { latLng ->
            updateLocationName(latLng)
        }
    }

    private fun updateLocationName(latLng: LatLng) {
        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)

        if (addresses != null) {
            if (addresses.isNotEmpty()) {
                val address = addresses?.get(0)
                val locationName = address?.getAddressLine(0)

                // Return result to the calling activity
                val resultIntent = Intent().apply {
                    putExtra(LOCATION_EXTRA, ParcelableLatLng(latLng.latitude, latLng.longitude))
                    putExtra(LOCATION_NAME_EXTRA, locationName)
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }

    companion object {
        const val LOCATION_EXTRA = "LOCATION_EXTRA"
        const val LOCATION_NAME_EXTRA = "LOCATION_NAME_EXTRA"
    }
}