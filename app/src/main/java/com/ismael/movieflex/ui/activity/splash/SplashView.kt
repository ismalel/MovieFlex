package com.ismael.movieflex.ui.activity.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ismael.movieflex.R
import com.ismael.movieflex.ui.activity.main.MainView

class SplashView : AppCompatActivity() {
    val TIMEOUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_view)
        runSplashScreen(TIMEOUT)
    }

    fun runSplashScreen(timeout: Long) {
        Handler().postDelayed({
            kotlin.run {
                val intent = Intent(this, MainView::class.java)
                startActivity(intent)
                finish()
            }
        }, timeout)
    }
}