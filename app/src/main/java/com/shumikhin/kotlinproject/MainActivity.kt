package com.shumikhin.kotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
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

        val countString = textView.text.toString()

        var count: Int = Integer.parseInt(countString)
        count++
        if (count==100) {

            val animation = AnimationUtils.loadAnimation(this,R.anim.cat1)
            imageCat.startAnimation(animation)
        }

        textView.text = count.toString()
    }

}
