package com.fd.soccer.ui.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fd.soccer.data.model.presentation.Team
import com.fd.soccer.databinding.TeamItemBinding

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
            Glide.with(ivLogo.context)
                .load(teams[position].strTeamBadge)
                .into(ivLogo)
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