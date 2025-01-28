package com.example.ridesharing

data class RideOption(
    val name: String,
    val price: String,
    val eta: String, // Estimated Time of Arrival
    val imageResource: Int
)
