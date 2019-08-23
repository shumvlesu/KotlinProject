package com.shumikhin.kotlinproject

import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view:View){
        Toast.makeText(this,"Hello universe",Toast.LENGTH_LONG).show()
    }

    fun countMe (view: View) {
        // Get the value of the text view.
        val countString = textView.text.toString()
        // Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count++
        if (count==100) {

            val animation = AnimationUtils.loadAnimation(this,R.anim.cat1)
            imageCat.startAnimation(animation)


           // val objectAnimator = ObjectAnimator.ofFloat(ImageView, "translationX", 100f)
            //objectAnimator.duration = 1000
            //objectAnimator.start()
        }
        // Display the new value in the text view.
        textView.text = count.toString()
    }



}
