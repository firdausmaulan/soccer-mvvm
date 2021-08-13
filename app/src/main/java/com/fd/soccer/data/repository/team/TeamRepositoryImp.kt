package com.fd.soccer.data.repository.team

import com.fd.soccer.data.local.AppDatabase
import com.fd.soccer.data.model.entity.TeamEntity
import com.fd.soccer.data.model.mapper.TeamMapper
import com.fd.soccer.data.model.request.TeamsRequest
import com.fd.soccer.data.remote.ApiService
import com.fd.soccer.util.DateUtil
import com.fd.soccer.util.RepositoryResult

class TeamRepositoryImp(
    private val apiService: ApiService,
    private val database: AppDatabase,
    private val mapper: TeamMapper
) : TeamRepository {

    override suspend fun getTeams(request: TeamsRequest): RepositoryResult<List<TeamEntity>> {
        var result = emptyList<TeamEntity>()
        try {
            val currentDate = DateUtil.getCurrentDate()
            result = database.teamDao().getAll(request.id, currentDate)
            return if (!result.isNullOrEmpty()) {
                RepositoryResult.success(result)
            } else {
                val response = apiService.getTeams(request.id)
                result = mapper.mapToEntity(response?.teams)
                database.teamDao().insertAll(result)
                result = database.teamDao().getAll(request.id, currentDate)
                RepositoryResult.success(result)
            }
        } catch (throwable: Throwable) {
            return if (result.isNotEmpty()) {
                RepositoryResult.success(result)
            } else {
                RepositoryResult.error(throwable)
            }
        }
    }

}