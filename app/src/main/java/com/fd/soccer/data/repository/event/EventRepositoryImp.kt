package com.fd.soccer.data.repository.event

import com.fd.soccer.data.local.AppDatabase
import com.fd.soccer.data.model.entity.EventEntity
import com.fd.soccer.data.model.mapper.EventMapper
import com.fd.soccer.data.model.request.EventRequest
import com.fd.soccer.data.remote.ApiService
import com.fd.soccer.util.DateUtil
import com.fd.soccer.util.RepositoryResult

class EventRepositoryImp(
    private val apiService: ApiService,
    private val database: AppDatabase,
    private val mapper: EventMapper
) : EventRepository {

    override suspend fun getLastEvent(request: EventRequest): RepositoryResult<List<EventEntity>> {
        var result = emptyList<EventEntity>()
        try {
            val currentDate = DateUtil.getCurrentDate()
            result = database.evenDao().getAll(request.id, currentDate)
            return if (!result.isNullOrEmpty()) {
                RepositoryResult.success(result)
            } else {
                val response = apiService.getLastEvents(request.id)
                result = mapper.mapToEntity(response?.results)
                database.evenDao().insertAll(result)
                result = database.evenDao().getAll(request.id, currentDate)
                RepositoryResult.success(result)
            }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            return if (result.isNotEmpty()) {
                RepositoryResult.success(result)
            } else {
                RepositoryResult.error(throwable)
            }
        }
    }

}