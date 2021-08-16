package com.fd.soccer.ui.lastevents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fd.soccer.data.model.domain.Event
import com.fd.soccer.databinding.EventItemBinding

class EventAdapter(private val events: ArrayList<Event>) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private var listener: Listener? = null

    interface Listener {
        fun onClick(event: Event)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EventItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: EventItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            tvEvent.text = events[position].strEvent
            tvScoreResult.text = events[position].strScoreResult
            tvLocalDateTime.text = events[position].dateTime
        }
    }

    override fun getItemCount() = events.size

    fun addAll(list: List<Event>) {
        for (event in list) {
            events.add(event)
            notifyItemInserted(events.size - 1)
        }
    }

    fun clear() {
        events.clear()
        notifyDataSetChanged()
    }
}