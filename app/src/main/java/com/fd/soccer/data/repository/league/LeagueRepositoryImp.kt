package com.fd.soccer.data.repository.league

import com.fd.soccer.data.local.AppDatabase
import com.fd.soccer.data.model.entity.LeagueEntity
import com.fd.soccer.data.model.mapper.LeagueMapper
import com.fd.soccer.data.model.request.LeaguesRequest
import com.fd.soccer.data.remote.ApiService
import com.fd.soccer.util.DateUtil
import com.fd.soccer.util.RepositoryResult
import java.lang.Exception

class LeagueRepositoryImp(
    private val apiService: ApiService,
    private val database: AppDatabase,
    private val mapper: LeagueMapper
) : LeagueRepository {

    override suspend fun getLeagues(request: LeaguesRequest): RepositoryResult<List<LeagueEntity>> {
        var result = emptyList<LeagueEntity>()
        try {
            val currentDate = DateUtil.getCurrentDate()
            result = database.leagueDao().getAll(request.country, currentDate)
            return if (!result.isNullOrEmpty()) {
                RepositoryResult.success(result)
            } else {
                val validDivision = "0123"
                val response = apiService.getLeagues(request.sport, request.country)
                val validLeagues = ArrayList<LeagueEntity>()
                response?.countrys?.forEach { country ->
                    if (validDivision.contains(country.strDivision.toString())) {
                        validLeagues.add(mapper.mapToEntity(country))
                    }
                }
                database.leagueDao().insertAll(validLeagues)
                result = database.leagueDao().getAll(request.country, currentDate)
                RepositoryResult.success(result)
            }
        } catch (ex : Exception) {
            ex.printStackTrace()
            return RepositoryResult.success(emptyList())
            /*return if (result.isNotEmpty()) {
                RepositoryResult.success(result)
            } else {
                RepositoryResult.error(throwable)
            }*/
        }
    }

}