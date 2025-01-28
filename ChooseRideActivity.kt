package com.example.ridesharing

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChooseRideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_ride)

        val rideOptions = listOf(
            RideOption("Economy", "Rs.100", "5 mins", R.drawable.ic_economy),
            RideOption("Premium", "Rs.200", "8 mins", R.drawable.ic_premium),
            RideOption("Carpool", "Rs.75", "10 mins", R.drawable.ic_carpool),
        )

        val recyclerView: RecyclerView = findViewById(R.id.rideOptionsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RideOptionsAdapter(rideOptions) { rideOption ->
            Toast.makeText(this, "Selected: ${rideOption.name}", Toast.LENGTH_SHORT).show()
        }

        val confirmButton: Button = findViewById(R.id.confirmRideButton)
        confirmButton.setOnClickListener {
            Toast.makeText(this, "Ride confirmed!", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
