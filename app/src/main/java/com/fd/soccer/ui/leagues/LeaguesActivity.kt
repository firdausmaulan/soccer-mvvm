package com.fd.soccer.ui.leagues

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fd.soccer.R

class LeaguesActivity : AppCompatActivity() {

    companion object {
        fun startIntent(activity: Activity): Intent {
            return Intent(activity, LeaguesActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leagues_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LeaguesFragment.newInstance())
                .commitNow()
        }
    }
}