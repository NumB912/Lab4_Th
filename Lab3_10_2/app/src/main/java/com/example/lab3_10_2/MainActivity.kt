
package com.example.lab3_10_2
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.transition.Transition
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    @SuppressLint("ObjectAnimatorBinding", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        imageView = findViewById(R.id.imageView)

        button.setOnClickListener {
            val translateX = ObjectAnimator.ofFloat(textView, "translationX", (Random.nextFloat()-Random.nextFloat())*300f)
            val translateY = ObjectAnimator.ofFloat(textView, "translationY", (Random.nextFloat()-Random.nextFloat())*300f)

            val textColor = ObjectAnimator.ofArgb(textView,"textColor",Color.BLACK,Color.argb(Random.nextInt(0,255),Random.nextInt(0,255),Random.nextInt(0,255),0))
            translateX.start()
            translateY.start()
            textColor.start()

        }

        imageView = findViewById(R.id.imageView)
        imageView.setBackgroundResource(R.drawable.animation)
        Toast.makeText(this,imageView.toString(),Toast.LENGTH_LONG).show()
        val animation = imageView.background as AnimationDrawable


        imageView.setOnClickListener{
            if(animation.isRunning()){
                animation.stop()
            }
            animation.start()

        }

        val buttonChangeActivity = findViewById<Button>(R.id.button2)

        buttonChangeActivity.setOnClickListener {
            val intent =Intent(this,MainActivity2::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)

        }


    }

}
