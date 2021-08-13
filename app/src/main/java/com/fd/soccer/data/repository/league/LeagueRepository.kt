package com.fd.soccer.data.repository.league

import com.fd.soccer.data.model.entity.LeagueEntity
import com.fd.soccer.data.model.request.LeaguesRequest
import com.fd.soccer.util.RepositoryResult

interface LeagueRepository {

    suspend fun getLeagues(request: LeaguesRequest): RepositoryResult<List<LeagueEntity>>

}