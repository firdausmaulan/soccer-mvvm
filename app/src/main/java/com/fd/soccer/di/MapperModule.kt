package com.fd.soccer.di

import com.fd.soccer.data.model.mapper.EventMapper
import com.fd.soccer.data.model.mapper.LeagueMapper
import com.fd.soccer.data.model.mapper.TeamMapper
import org.koin.dsl.module

val MapperModule = module {

    single { provideLeagueMapper() }

    single { provideTeamMapper() }

    single { provideEventMapper() }

}

fun provideLeagueMapper(): LeagueMapper {
    return LeagueMapper()
}

fun provideTeamMapper(): TeamMapper {
    return TeamMapper()
}

fun provideEventMapper(): EventMapper {
    return EventMapper()
}