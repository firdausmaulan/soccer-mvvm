package com.fd.soccer.di

import com.fd.soccer.data.model.mapper.LeagueMapper
import com.fd.soccer.data.model.mapper.TeamMapper
import org.koin.dsl.module

val MapperModule = module {

    factory { provideLeagueMapper() }

    factory { provideTeamMapper() }

}

fun provideLeagueMapper(): LeagueMapper {
    return LeagueMapper()
}

fun provideTeamMapper(): TeamMapper {
    return TeamMapper()
}