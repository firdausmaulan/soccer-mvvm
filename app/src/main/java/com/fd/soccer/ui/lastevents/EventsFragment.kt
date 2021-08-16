package com.fd.soccer.ui.lastevents

import android.view.LayoutInflater
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.fd.soccer.data.model.domain.Event
import com.fd.soccer.data.model.request.EventRequest
import com.fd.soccer.databinding.EventsFragmentBinding
import com.fd.soccer.ui.base.BaseFragment
import com.fd.soccer.util.Status
import com.fd.soccer.util.hide
import com.fd.soccer.util.show
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsFragment(private val teamId: String) : BaseFragment<EventsFragmentBinding>() {

    private val viewModel: EventsViewModel by viewModel()
    private lateinit var adapter: EventAdapter

    companion object {
        fun newInstance(teamId: String) = EventsFragment(teamId)
    }

    override val bindingInflater: (LayoutInflater) -> EventsFragmentBinding
        get() = EventsFragmentBinding::inflate

    override fun setupView(binding: EventsFragmentBinding) {
        adapter = EventAdapter(arrayListOf())
        binding.rvEvent.addItemDecoration(
            DividerItemDecoration(requireActivity(), RecyclerView.VERTICAL)
        )
        binding.rvEvent.adapter = adapter

        adapter.setListener(object : EventAdapter.Listener {
            override fun onClick(event: Event) {

            }
        })
    }

    override fun setupObserver() {
        viewModel.fetchLastEvents(EventRequest(teamId))
        viewModel.eventsLiveData.observe(this, {
            when (it.status) {
                Status.LOADING -> {
                    binding.progressBar.show()
                    binding.rvEvent.hide()
                }
                Status.SUCCESS -> {
                    binding.progressBar.hide()
                    binding.rvEvent.show()
                    it.data?.let { events -> renderList(events) }
                }
                Status.ERROR -> {
                    //Handle Error
                    binding.progressBar.hide()
                    binding.rvEvent.hide()
                    baseDialog.show(binding.container, it.throwable)
                }
            }
        })
    }

    private fun renderList(events: List<Event>) {
        adapter.clear()
        adapter.addAll(events)
    }
}