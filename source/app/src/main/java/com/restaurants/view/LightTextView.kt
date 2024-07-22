package com.restaurants.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class LightTextView : AppCompatTextView {

    constructor(context: Context) : super(context) {
        setCustomFont(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setCustomFont(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr) {
        setCustomFont(context)
    }

    private fun setCustomFont(context: Context) {
        try {
            typeface = Typeface.createFromAsset(context.assets, "font/Roboto-Light.ttf")
        } catch (e: Exception) {
            e.printStackTrace()
            // Optionally, you can set a default font or handle the error in a user-friendly way.
        }
    }
}
