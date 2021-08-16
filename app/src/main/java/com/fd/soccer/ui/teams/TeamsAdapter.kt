package com.fd.soccer.ui.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fd.soccer.data.model.domain.Team
import com.fd.soccer.databinding.TeamItemBinding
import com.fd.soccer.util.loadImage

class TeamsAdapter(private val teams: ArrayList<Team>) :
    RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    private var listener: Listener? = null

    interface Listener {
        fun onClick(team: Team)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TeamItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: TeamItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            ivLogo.loadImage(teams[position].strTeamBadge)
            tvName.text = teams[position].strTeam
            container.setOnClickListener { listener?.onClick(teams[position]) }
        }
    }

    override fun getItemCount() = teams.size

    fun addAll(list: List<Team>) {
        for (team in list) {
            teams.add(team)
            notifyItemInserted(teams.size - 1)
        }
    }

    fun clear() {
        teams.clear()
        notifyDataSetChanged()
    }
}