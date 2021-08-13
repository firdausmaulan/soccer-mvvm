package com.fd.soccer.data.repository.team

import com.fd.soccer.data.model.entity.TeamEntity
import com.fd.soccer.data.model.request.TeamsRequest
import com.fd.soccer.util.RepositoryResult

interface TeamRepository {

    suspend fun getTeams(request: TeamsRequest): RepositoryResult<List<TeamEntity>>

}