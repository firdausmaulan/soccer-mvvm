package com.fd.soccer.data.remote

import com.fd.soccer.data.model.response.EventsResponse
import com.fd.soccer.data.model.response.LeaguesResponse
import com.fd.soccer.data.model.response.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search_all_leagues.php")
    suspend fun getLeagues(
        @Query("s") sport: String,
        @Query("c") country: String
    ): LeaguesResponse?

    @GET("lookup_all_teams.php")
    suspend fun getTeams(
        @Query("id") id: String
    ): TeamsResponse?

    @GET("eventslast.php")
    suspend fun getLastEvents(
        @Query("id") id: String
    ): EventsResponse?
}