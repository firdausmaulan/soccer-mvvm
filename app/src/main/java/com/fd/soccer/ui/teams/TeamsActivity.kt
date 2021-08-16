package com.fd.soccer.ui.teams

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fd.soccer.R
import com.fd.soccer.data.model.domain.League

class TeamsActivity : AppCompatActivity() {

    private lateinit var league: League

    companion object {
        const val LEAGUE = "league"

        fun startIntent(activity: Activity, league: League?): Intent {
            val intent = Intent(activity, TeamsActivity::class.java)
            intent.putExtra(LEAGUE, league)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teams_activity)

        league = intent.getParcelableExtra<League>(LEAGUE) ?: League()

        supportActionBar?.title = league.strLeague
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TeamsFragment.newInstance(league.idLeague))
                .commitNow()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}