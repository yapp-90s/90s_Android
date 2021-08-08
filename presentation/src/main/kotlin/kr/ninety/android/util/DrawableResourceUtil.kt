package kr.ninety.android.util

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt

object DrawableResourceUtil {
    fun setBackground(
        context: Context,
        @ColorInt
        backgroundColor: Int? = null,
        cornerRadius: Float? = null,
        @ColorInt
        strokeColor: Int? = null,
        strokePixel: Float? = null
    ): GradientDrawable {
        val radius = cornerRadius?.let {
            cornerRadius * (context.resources.displayMetrics.density)
        }?: 0f

        return GradientDrawable().also { gradientDrawable ->
            backgroundColor?.let { color ->
                gradientDrawable.setColor(color)
            }

            gradientDrawable.cornerRadius = radius

            if (strokeColor != null && strokePixel != null) {
                val strokeWithPixel = (strokePixel * (context.resources.displayMetrics.density)).toInt()
                gradientDrawable.setStroke(strokeWithPixel, strokeColor)
            }
        }
    }
}
