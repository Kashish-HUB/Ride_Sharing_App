package com.example.ridesharing

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.views.MapView
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Marker

class MainActivity : AppCompatActivity() {

    private lateinit var mapView: MapView
    private lateinit var searchPickup: EditText
    private lateinit var searchDropoff: EditText
    private lateinit var currentLocationButton: Button
    private lateinit var rideOptionButton: Button
    private lateinit var requestRideButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load the OSM configuration
        Configuration.getInstance().userAgentValue = packageName

        setContentView(R.layout.activity_main)

        // Initialize views
        mapView = findViewById(R.id.mapView)
        searchPickup = findViewById(R.id.searchPickup)
        searchDropoff = findViewById(R.id.searchDropoff)
        currentLocationButton = findViewById(R.id.currentLocationButton)
        rideOptionButton = findViewById(R.id.rideOptionButton)
        requestRideButton = findViewById(R.id.requestRideButton)

        // Configure map settings
        mapView.setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)
        mapView.setBuiltInZoomControls(true)
        mapView.setMultiTouchControls(true)

        // Set a default location (e.g., New York)
        val startPoint = GeoPoint(40.7128, -74.0060) // Example coordinates
        mapView.controller.setCenter(startPoint)
        mapView.controller.setZoom(15)

        // Adding a marker to the map (for testing)
        val marker = Marker(mapView)
        marker.position = startPoint
        marker.title = "New York"
        mapView.overlays.add(marker)

        // Current Location Button Click Listener
        currentLocationButton.setOnClickListener {
            val currentLocation = GeoPoint(40.730610, -73.935242) // Placeholder for current location
            mapView.controller.setCenter(currentLocation)
            mapView.controller.setZoom(15)
            Toast.makeText(this, "Moved to Current Location", Toast.LENGTH_SHORT).show()
        }

        // Ride Option Button Click Listener (for selecting ride type)
        rideOptionButton.setOnClickListener {
            val intent = Intent(this, ChooseRideActivity::class.java)
            startActivity(intent)
        }

        // Request Ride Button Click Listener
        requestRideButton.setOnClickListener {
            val intent = Intent(this, RequestRideActivity::class.java)
            startActivity(intent)
        }
    }
}
