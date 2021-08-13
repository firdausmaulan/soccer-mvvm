package com.fd.soccer.ui.teams

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.fd.soccer.data.model.presentation.Team
import com.fd.soccer.data.model.request.TeamsRequest
import com.fd.soccer.databinding.TeamsFragmentBinding
import com.fd.soccer.ui.base.BaseFragment
import com.fd.soccer.util.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamsFragment(private val leagueId : String) : BaseFragment<TeamsFragmentBinding>() {

    private val viewModel: TeamsViewModel by viewModel()
    private lateinit var adapter: TeamsAdapter

    companion object {
        fun newInstance(leagueId: String) = TeamsFragment(leagueId)
    }

    override val bindingInflater: (LayoutInflater) -> TeamsFragmentBinding
        get() = TeamsFragmentBinding::inflate

    override fun setupView(binding: TeamsFragmentBinding) {
        adapter = TeamsAdapter(arrayListOf())
        binding.rvTeam.addItemDecoration(
            DividerItemDecoration(requireActivity(), RecyclerView.VERTICAL)
        )
        binding.rvTeam.adapter = adapter

        adapter.setListener(object : TeamsAdapter.Listener {
            override fun onClick(team: Team) {

            }
        })
    }

    override fun setupObserver() {
        viewModel.fetchTeams(TeamsRequest(leagueId))
        viewModel.teamsLiveData.observe(this, {
            when (it.status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rvTeam.visibility = View.GONE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { teams -> renderList(teams) }
                    binding.rvTeam.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    //Handle Error
                    binding.progressBar.visibility = View.GONE
                    baseDialog.show(binding.container, it.throwable)
                }
            }
        })
    }

    private fun renderList(teams: List<Team>) {
        adapter.clear()
        adapter.addAll(teams)
    }
}