package com.fd.soccer.data.repository.event

import com.fd.soccer.data.model.entity.EventEntity
import com.fd.soccer.data.model.request.EventRequest
import com.fd.soccer.util.RepositoryResult

interface EventRepository {

    suspend fun getLastEvent(request: EventRequest): RepositoryResult<List<EventEntity>>

}