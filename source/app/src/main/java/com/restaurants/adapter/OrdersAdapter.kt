package com.demo.donation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.restaurants.databinding.OrderDetailsBinding
import com.restaurants.model.OrdersModel

class OrdersAdapter(private val dataList: ArrayList<OrdersModel>) : RecyclerView.Adapter<OrdersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = OrderDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        anim(holder.itemView)
        holder.binding.image.setImageResource(dataList[position].image)
        holder.binding.imgName.text = dataList[position].imgName
        holder.binding.restaurantName.text = dataList[position].restaurantName
        holder.binding.price.text = dataList[position].price
    }

    private fun anim(view: View) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 1500
        view.startAnimation(animation)
    }

    inner class MyViewHolder(val binding: OrderDetailsBinding) : RecyclerView.ViewHolder(binding.root)
}
