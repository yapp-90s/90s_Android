package kr.ninety.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kr.ninety.android.util.DrawableResourceUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)

        /**
         * Example
         */
        button.background = DrawableResourceUtil.gradientDrawable(
            context = this,
            backgroundColor = resources.getColor(R.color.orange, null),
            cornerRadius = 8f
        )
    }
}
