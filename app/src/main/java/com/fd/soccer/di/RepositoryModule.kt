package com.fd.soccer.di

import com.fd.soccer.data.local.AppDatabase
import com.fd.soccer.data.model.mapper.EventMapper
import com.fd.soccer.data.model.mapper.LeagueMapper
import com.fd.soccer.data.model.mapper.TeamMapper
import com.fd.soccer.data.remote.ApiService
import com.fd.soccer.data.repository.event.EventRepository
import com.fd.soccer.data.repository.event.EventRepositoryImp
import com.fd.soccer.data.repository.league.LeagueRepository
import com.fd.soccer.data.repository.league.LeagueRepositoryImp
import com.fd.soccer.data.repository.team.TeamRepository
import com.fd.soccer.data.repository.team.TeamRepositoryImp
import org.koin.dsl.module

val RepositoryModule = module {

    single { provideLeagueRepository(get(), get(), get()) }

    single { provideTeamRepository(get(), get(), get()) }

    single { provideEventRepository(get(), get(), get()) }

}

fun provideLeagueRepository(apiService: ApiService, database: AppDatabase, mapper: LeagueMapper)
        : LeagueRepository {
    return LeagueRepositoryImp(apiService, database, mapper)
}

fun provideTeamRepository(apiService: ApiService, database: AppDatabase, mapper: TeamMapper)
        : TeamRepository {
    return TeamRepositoryImp(apiService, database, mapper)
}

fun provideEventRepository(apiService: ApiService, database: AppDatabase, mapper: EventMapper)
        : EventRepository {
    return EventRepositoryImp(apiService, database, mapper)
}