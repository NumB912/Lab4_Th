package com.example.lab3_10_1
import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAnimate = findViewById<Button>(R.id.btnAnimate)
        btnAnimate.setOnClickListener {
            // Thay đổi vị trí của button
            ObjectAnimator.ofFloat(btnAnimate, "translationX", 300f).apply {
                duration = 1000
                start()
            }
            // Thay đổi kích thước của button
            ObjectAnimator.ofFloat(btnAnimate, "scaleX", 2f).apply {
                duration = 1000
                start()
            }
            // Thay đổi màu nền của button
            btnAnimate.setBackgroundColor(Color.RED)
        }
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val btnAnimateTransition = findViewById<Button>(R.id.btnAnimateTransition)
        btnAnimateTransition.setOnClickListener {
            // Bắt đầu hiệu ứng chuyển cảnh
            TransitionManager.beginDelayedTransition(constraintLayout)
            // Thay đổi vị trí và kích thước của button
            btnAnimateTransition.layoutParams.width = 500
            btnAnimateTransition.requestLayout()
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setBackgroundResource(R.drawable.animated_button)
        val animationDrawable = imageView.background as AnimationDrawable
        imageView.setOnClickListener {
            Toast.makeText(this,"Cliked",Toast.LENGTH_LONG).show()// STOPSHIP:
            if (animationDrawable.isRunning) {
                animationDrawable.stop() // Dừng nếu đang chạy
            }
            animationDrawable.start()
        }




    }
}
