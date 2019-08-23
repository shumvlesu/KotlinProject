package com.shumikhin.kotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import io.reactivex.Completable
import io.reactivex.subjects.CompletableSubject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val durationMs = 600L

        //пока делаем котика невидимым
        imageCat.alpha = 0f

        //анимация появления кнопок
        toast_button.alpha = 0f
        count_button.alpha = 0f
        random_button.alpha = 0f

        fadeIn(toast_button, durationMs)
            .andThen(fadeIn(count_button, durationMs))
            .andThen(fadeIn(random_button, durationMs)).subscribe()

    }

    fun toastMe(view:View){
        Toast.makeText(this,"Hello universe",Toast.LENGTH_LONG).show()
    }

    fun countMe (view: View) {

        val countString = textView.text.toString()

        var count: Int = Integer.parseInt(countString)
        count++
        if (count==10) {

            val durationMs = 700L

            imageCat.alpha = 0f
            fadeIn(imageCat, durationMs).subscribe()

           //анимация без rxjava2 c помощью xml cat.xml в anim
           //val animation = AnimationUtils.loadAnimation(this,R.anim.cat1)
           //imageCat.startAnimation(animation)
        }

        textView.text = count.toString()
    }

    fun fadeIn(view: View, duration: Long): Completable {
        val animationSubject = CompletableSubject.create()
        return animationSubject.doOnSubscribe {
            ViewCompat.animate(view)
                .setDuration(duration)
                .alpha(1f)
                .withEndAction {
                    animationSubject.onComplete()
                }
        }
    }

}
