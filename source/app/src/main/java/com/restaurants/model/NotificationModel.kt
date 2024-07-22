package com.restaurants.model

data class NotificationModel(
    val imageResId: Int,
    val heading: String,
    val description: String,
    val time: String,
    val isHighlighted: Boolean = false // Add this property
)
