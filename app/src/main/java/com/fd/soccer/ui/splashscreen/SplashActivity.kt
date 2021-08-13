package com.fd.soccer.ui.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.fd.soccer.R
import com.fd.soccer.ui.leagues.LeaguesActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = LeaguesActivity.startIntent(this)
            startActivity(intent)
            finish()
        }, 3000)

    }
}