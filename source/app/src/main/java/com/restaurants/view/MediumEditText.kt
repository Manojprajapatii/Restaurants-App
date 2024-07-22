package com.restaurants.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText



class MediumEditText : AppCompatEditText {
    constructor(context: Context) : super(context) {
        setassets(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setassets(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setassets(context)
    }


    private fun setassets(context: Context) {
        typeface = Typeface.createFromAsset(context.assets, "font/MYRIADPRO_SEMIBOLD.OTF")
    }
}
