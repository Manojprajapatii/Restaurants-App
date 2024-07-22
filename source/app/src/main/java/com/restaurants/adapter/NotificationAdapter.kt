package com.restaurants.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.restaurants.R
import com.restaurants.databinding.ActivityNotificationBinding

import com.restaurants.databinding.NotificationRecyclerBinding
import com.restaurants.model.NotificationModel

class NotificationAdapter(private val context: Context, private val notificationList: List<NotificationModel>)
    : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {
    private lateinit var binding: ActivityNotificationBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = NotificationRecyclerBinding.inflate(LayoutInflater.from(context), parent, false)
        return NotificationViewHolder(binding)


    }



    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notificationList[position]
        with(holder.binding) {
            notificationImage.setImageResource(notification.imageResId)
            heading.text = notification.heading
            description.text = notification.description
            watchImage.setImageResource(R.drawable.watch)
            time.text = notification.time

            // Apply color filter if highlighted
            if (notification.isHighlighted) {
                notificationImage.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN) // Change color as needed
            } else {
                notificationImage.clearColorFilter()
            }
        }
    }



    override fun getItemCount() = notificationList.size

    inner class NotificationViewHolder(val binding: NotificationRecyclerBinding) : RecyclerView.ViewHolder(binding.root)
}
