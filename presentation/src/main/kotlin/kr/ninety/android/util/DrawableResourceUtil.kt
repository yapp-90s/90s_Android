package kr.ninety.android.util

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt

object DrawableResourceUtil {
    fun gradientDrawable(
        context: Context,
        @ColorInt
        backgroundColor: Int? = null,
        cornerRadius: Float? = null,
        strokeColor: ColorDrawable? = null,
        strokeResId: Int? = null
    ): GradientDrawable {
        val radius = cornerRadius?.let {
            cornerRadius * (context.resources.displayMetrics.density)
        }?: 0f

        return GradientDrawable().also { gradientDrawable ->
            backgroundColor?.let { color ->
                gradientDrawable.setColor(color)
            }

            gradientDrawable.cornerRadius = radius

            if (strokeColor != null && strokeResId != null) {
                val strokeWithPixel = strokeResId * (context.resources.getDimensionPixelSize(strokeResId))
                gradientDrawable.setStroke(strokeWithPixel, strokeColor.color)
            }
        }
    }
}
