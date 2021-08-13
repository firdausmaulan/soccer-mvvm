package com.fd.soccer.ui.leagues

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fd.soccer.data.model.presentation.League
import com.fd.soccer.databinding.LeagueItemBinding

class LeagueAdapter(private val leagues: ArrayList<League>) :
    RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    private var listener: Listener? = null

    interface Listener {
        fun onClick(league: League)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LeagueItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: LeagueItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            Glide.with(ivLogo.context)
                .load(leagues[position].strBadge)
                .into(ivLogo)
            tvName.text = leagues[position].strLeague
            container.setOnClickListener { listener?.onClick(leagues[position]) }
        }
    }

    override fun getItemCount() = leagues.size

    fun addAll(list: List<League>) {
        for (league in list) {
            leagues.add(league)
            notifyItemInserted(leagues.size - 1)
        }
    }

    fun clear() {
        leagues.clear()
        notifyDataSetChanged()
    }
}