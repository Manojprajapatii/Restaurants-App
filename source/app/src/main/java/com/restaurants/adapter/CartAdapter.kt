package com.demo.donation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.restaurants.databinding.FoodRecyclerBinding
import com.restaurants.fragment.Cart

import com.restaurants.model.CartModel

class CartAdapter(var dataList: ArrayList<CartModel>, var context: Cart) : RecyclerView.Adapter<CartAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = FoodRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        holder.binding.towX.text = dataList[position].towX
        holder.itemView.setOnClickListener{

        }
    }

    fun anim(view: View){
        var animation= AlphaAnimation(0.0f,1.0f)
        animation.duration =1500
        view.startAnimation(animation)
    }

    inner class MyViewHolder(var binding: FoodRecyclerBinding) : RecyclerView.ViewHolder(binding.root)
}
