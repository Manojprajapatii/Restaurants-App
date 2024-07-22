package com.demo.donation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.restaurants.databinding.ActivityOfferRecyclerBinding
import com.restaurants.fragment.Offers
import com.restaurants.model.OfferModel

class OfferAdapter(
    private var dataList: ArrayList<OfferModel>,
    private var colorList: List<Int>, // List of colors
    private var context: Offers
) : RecyclerView.Adapter<OfferAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ActivityOfferRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]

        holder.binding.image.setImageResource(item.image)
        holder.binding.food.text = item.food
        holder.binding.off.text = item.off
        holder.binding.foodOrder.text = item.foodOrder
//        holder.binding.btn.text = item.btn

        // Set card background color dynamically
        val color = colorList[position % colorList.size]
        holder.binding.cardView.setCardBackgroundColor(ContextCompat.getColor(context.requireContext(), color))

        holder.itemView.setOnClickListener {
            // Handle item click
        }
    }

    inner class MyViewHolder(val binding: ActivityOfferRecyclerBinding) : RecyclerView.ViewHolder(binding.root)
}
