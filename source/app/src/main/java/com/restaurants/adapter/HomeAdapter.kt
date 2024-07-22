package com.restaurants.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.restaurants.activity.ViewAllProducts
import com.restaurants.databinding.HomeRecyclerBinding
import com.restaurants.model.HomeModel

class HomeAdapter(
    var dataList: ArrayList<HomeModel>,
    var context: Context
) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = HomeRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        anim(holder.itemView)

        holder.binding.foodImg.setImageResource(dataList[position].foodImg)
        holder.binding.planetGrapes.text = dataList[position].planetGrapes
        holder.binding.tagLine.text = dataList[position].tagLine
        holder.binding.viewAll.text = dataList[position].viewAll

        holder.binding.viewAll.setOnClickListener {
            // Handle click event for viewAll button
            val intent = Intent(context, ViewAllProducts::class.java)
            context.startActivity(intent)
        }

        holder.itemView.setOnClickListener {
            // Handle click event for the entire item if needed
        }
    }

    fun anim(view: View) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 1500
        view.startAnimation(animation)
    }

    inner class MyViewHolder(var binding: HomeRecyclerBinding) : RecyclerView.ViewHolder(binding.root)
}
