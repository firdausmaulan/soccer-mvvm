package com.fd.soccer.ui.lastevents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fd.soccer.R
import com.fd.soccer.data.model.domain.Team

class EventsActivity : AppCompatActivity() {

    private lateinit var team: Team

    companion object {
        const val TEAM = "team"

        fun startIntent(activity: Activity, team: Team): Intent {
            val intent = Intent(activity, EventsActivity::class.java)
            intent.putExtra(TEAM, team)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.events_activity)

        team = intent.getParcelableExtra(TEAM) ?: Team()

        supportActionBar?.title = team.strTeam
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EventsFragment.newInstance(team.idTeam))
                .commitNow()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}