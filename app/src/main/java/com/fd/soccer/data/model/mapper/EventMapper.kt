package com.fd.soccer.data.model.mapper

import com.fd.soccer.data.model.domain.Event
import com.fd.soccer.data.model.entity.EventEntity
import com.fd.soccer.data.model.response.Result
import com.fd.soccer.util.DateUtil

class EventMapper {

    fun mapToEntity(eventResult: Result): EventEntity {
        return EventEntity(
            idEvent = eventResult.idEvent ?: "",
            strEvent = eventResult.strEvent,
            strHomeTeam = eventResult.strHomeTeam,
            strAwayTeam = eventResult.strAwayTeam,
            intHomeScore = eventResult.intHomeScore,
            intAwayScore = eventResult.intAwayScore,
            strTimestamp = eventResult.strTimestamp,
            dateEvent = eventResult.dateEventLocal,
            strTime = eventResult.strTimeLocal,
            idHomeTeam = eventResult.idHomeTeam,
            idAwayTeam = eventResult.idAwayTeam,
            cachedAt = DateUtil.getCurrentDate()
        )
    }

    fun mapToEntity(eventResults: List<Result>?): List<EventEntity> {
        if (eventResults.isNullOrEmpty()) return emptyList()
        return eventResults.map { mapToEntity(it) }
    }

    fun mapToDomain(entity: EventEntity): Event {
        return Event(
            idEvent = entity.idEvent,
            strEvent = entity.strEvent ?: "",
            strHomeTeam = entity.strHomeTeam ?: "",
            strAwayTeam = entity.strAwayTeam ?: "",
            intHomeScore = entity.intHomeScore ?: "-",
            intAwayScore = entity.intAwayScore ?: "-",
            strTimestamp = entity.strTimestamp ?: "",
            dateEvent = entity.dateEvent ?: "-",
            strTime = entity.strTime ?: "-",
            idHomeTeam = entity.idHomeTeam ?: "",
            idAwayTeam = entity.idAwayTeam ?: "",
            strScoreResult = "${entity.intHomeScore ?: "-"} : ${entity.intAwayScore ?: "-"}",
            dateTime = "${entity.dateEvent ?: "-"} ${entity.strTime ?: "-"}"
        )
    }

    fun mapToDomain(entities: List<EventEntity>?): List<Event> {
        if (entities.isNullOrEmpty()) return emptyList()
        return entities.map { mapToDomain(it) }
    }
}