package com.example.ridesharing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RideOptionsAdapter(
    private val rideOptions: List<RideOption>,
    private val onClick: (RideOption) -> Unit
) : RecyclerView.Adapter<RideOptionsAdapter.RideOptionViewHolder>() {

    inner class RideOptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rideImage: ImageView = itemView.findViewById(R.id.rideImage)
        val rideName: TextView = itemView.findViewById(R.id.rideName)
        val ridePrice: TextView = itemView.findViewById(R.id.ridePrice)
        val rideETA: TextView = itemView.findViewById(R.id.rideETA)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RideOptionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ride_option, parent, false)
        return RideOptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RideOptionViewHolder, position: Int) {
        val rideOption = rideOptions[position]
        holder.rideName.text = rideOption.name
        holder.ridePrice.text = rideOption.price
        holder.rideETA.text = rideOption.eta
        holder.rideImage.setImageResource(rideOption.imageResource)
        holder.itemView.setOnClickListener { onClick(rideOption) }
    }

    override fun getItemCount() = rideOptions.size
}
