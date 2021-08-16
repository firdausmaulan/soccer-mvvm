package com.fd.soccer.ui.lastevents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fd.soccer.data.model.domain.Event
import com.fd.soccer.data.model.mapper.EventMapper
import com.fd.soccer.data.model.request.EventRequest
import com.fd.soccer.data.repository.event.EventRepository
import com.fd.soccer.util.State
import com.fd.soccer.util.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EventsViewModel(
    private val eventRepository: EventRepository,
    private val eventMapper: EventMapper
) : ViewModel() {

    val eventsLiveData = MutableLiveData<State<List<Event>>>()

    fun fetchLastEvents(request: EventRequest) {
        viewModelScope.launch {
            eventsLiveData.postValue(State.loading())
            val result = withContext(Dispatchers.IO) { eventRepository.getLastEvent(request) }
            if (result.status == Status.SUCCESS) {
                val teams = eventMapper.mapToDomain(result.data)
                eventsLiveData.postValue(State.success(teams))
            } else {
                eventsLiveData.postValue(State.error(result.throwable))
            }
        }
    }

}