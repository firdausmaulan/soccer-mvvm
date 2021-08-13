package com.fd.soccer.ui.leagues

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.fd.soccer.data.model.presentation.League
import com.fd.soccer.databinding.LeaguesFragmentBinding
import com.fd.soccer.ui.base.BaseFragment
import com.fd.soccer.ui.teams.TeamsActivity
import com.fd.soccer.util.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class LeaguesFragment : BaseFragment<LeaguesFragmentBinding>() {

    private val viewModel: LeaguesViewModel by viewModel()
    private lateinit var adapter: LeagueAdapter

    companion object {
        fun newInstance() = LeaguesFragment()
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
                val intent = TeamsActivity.startIntent(requireActivity(), league.idLeague)
                startActivity(intent)
            }
        })
    }

    override fun setupObserver() {
        viewModel.leaguesLiveData.observe(this, {
            when (it.status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rvLeague.visibility = View.GONE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { leagues -> renderList(leagues) }
                    binding.rvLeague.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    //Handle Error
                    binding.progressBar.visibility = View.GONE
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