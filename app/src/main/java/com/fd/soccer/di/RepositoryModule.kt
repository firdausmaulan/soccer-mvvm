package com.fd.soccer.di

import com.fd.soccer.data.local.AppDatabase
import com.fd.soccer.data.model.mapper.LeagueMapper
import com.fd.soccer.data.model.mapper.TeamMapper
import com.fd.soccer.data.remote.ApiService
import com.fd.soccer.data.repository.league.LeagueRepository
import com.fd.soccer.data.repository.league.LeagueRepositoryImp
import com.fd.soccer.data.repository.team.TeamRepository
import com.fd.soccer.data.repository.team.TeamRepositoryImp
import org.koin.dsl.module

val RepositoryModule = module {

    single { provideLeagueRepository(get(), get(), get()) }

    single { provideTeamRepository(get(), get(), get()) }

}

fun provideLeagueRepository(
    apiService: ApiService,
    database: AppDatabase,
    mapper: LeagueMapper
): LeagueRepository {
    return LeagueRepositoryImp(apiService, database, mapper)
}

fun provideTeamRepository(
    apiService: ApiService,
    database: AppDatabase,
    mapper: TeamMapper
): TeamRepository {
    return TeamRepositoryImp(apiService, database, mapper)
}