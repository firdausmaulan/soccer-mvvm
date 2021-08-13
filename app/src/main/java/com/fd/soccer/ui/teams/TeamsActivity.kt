package com.fd.soccer.ui.teams

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fd.soccer.R

class TeamsActivity : AppCompatActivity() {

    private lateinit var leagueId: String

    companion object {
        const val LEAGUE_ID = "leagueId"

        fun startIntent(activity: Activity, leagueId: String?): Intent {
            val intent = Intent(activity, TeamsActivity::class.java)
            intent.putExtra(LEAGUE_ID, leagueId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teams_activity)

        leagueId = intent.getStringExtra(LEAGUE_ID) ?: ""

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TeamsFragment.newInstance(leagueId))
                .commitNow()
        }
    }
}