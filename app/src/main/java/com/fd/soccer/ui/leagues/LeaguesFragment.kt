package com.fd.soccer.ui.leagues

import android.view.LayoutInflater
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.fd.soccer.data.model.domain.League
import com.fd.soccer.data.model.request.LeaguesRequest
import com.fd.soccer.databinding.LeaguesFragmentBinding
import com.fd.soccer.ui.base.BaseFragment
import com.fd.soccer.ui.teams.TeamsActivity
import com.fd.soccer.util.Constant
import com.fd.soccer.util.Status
import com.fd.soccer.util.hide
import com.fd.soccer.util.show
import org.koin.androidx.viewmodel.ext.android.viewModel

class LeaguesFragment(private val country: String) : BaseFragment<LeaguesFragmentBinding>() {

    private val viewModel: LeaguesViewModel by viewModel()
    private lateinit var adapter: LeagueAdapter

    companion object {
        fun newInstance(country: String) = LeaguesFragment(country)
    }

    override val bindingInflater: (LayoutInflater) -> LeaguesFragmentBinding
        get() = LeaguesFragmentBinding::inflate

    override fun setupView(binding: LeaguesFragmentBinding) {
        adapter = LeagueAdapter(arrayListOf())
        binding.rvLeague.addItemDecoration(
            DividerItemDecoration(requireActivity(), RecyclerView.VERTICAL)
        )
        binding.rvLeague.adapter = adapter

        adapter.setListener(object : LeagueAdapter.Listener {
            override fun onClick(league: League) {
                val intent = TeamsActivity.startIntent(requireActivity(), league)
                startActivity(intent)
            }
        })
    }

    override fun setupObserver() {
        viewModel.fetchLeagues(LeaguesRequest(Constant.SPORT, country))
        viewModel.leaguesLiveData.observe(this, {
            when (it.status) {
                Status.LOADING -> {
                    binding.progressBar.show()
                    binding.rvLeague.hide()
                }
                Status.SUCCESS -> {
                    binding.progressBar.hide()
                    binding.rvLeague.show()
                    it.data?.let { leagues -> renderList(leagues) }
                }
                Status.ERROR -> {
                    //Handle Error
                    binding.progressBar.hide()
                    binding.rvLeague.hide()
                    baseDialog.show(binding.container, it.throwable)
                }
            }
        })
    }

    private fun renderList(leagues: List<League>) {
        adapter.clear()
        adapter.addAll(leagues)
    }
}