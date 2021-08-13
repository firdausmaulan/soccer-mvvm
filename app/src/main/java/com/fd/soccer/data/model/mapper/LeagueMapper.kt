package com.fd.soccer.data.model.mapper

import com.fd.soccer.data.model.entity.LeagueEntity
import com.fd.soccer.data.model.presentation.League
import com.fd.soccer.data.model.response.Country
import com.fd.soccer.util.Constant
import com.fd.soccer.util.DateUtil

class LeagueMapper {

    fun mapToEntity(country: Country): LeagueEntity {
        return LeagueEntity(
            idLeague = country.idLeague ?: "",
            strLeague = country.strLeague,
            strDivision = country.strDivision,
            strCountry = country.strCountry,
            strCurrentSeason = country.strCurrentSeason,
            strDescription = country.strDescriptionEN,
            strFanArt = country.strFanart1,
            strBanner = country.strBanner,
            strBadge = country.strBadge,
            strLogo = country.strLogo,
            strPoster = country.strPoster,
            strTrophy = country.strTrophy,
            cachedAt = DateUtil.getCurrentDate()
        )
    }

    fun mapToEntity(countries: List<Country>?): List<LeagueEntity> {
        if (countries.isNullOrEmpty()) return emptyList()
        return countries.map { mapToEntity(it) }
    }

    fun mapToPresentation(entity: LeagueEntity): League {
        return League(
            idLeague = entity.idLeague,
            strLeague = entity.strLeague,
            strDivision = getDivisionName(entity.strDivision),
            strCountry = entity.strCountry,
            strCurrentSeason = entity.strCurrentSeason,
            strDescription = entity.strDescription,
            strFanArt = entity.strFanArt + Constant.PREVIEW_IMG,
            strBanner = entity.strBanner + Constant.PREVIEW_IMG,
            strBadge = entity.strBadge + Constant.PREVIEW_IMG,
            strLogo = entity.strLogo + Constant.PREVIEW_IMG,
            strPoster = entity.strPoster + Constant.PREVIEW_IMG,
            strTrophy = entity.strTrophy + Constant.PREVIEW_IMG,
        )
    }

    fun mapToPresentation(entities: List<LeagueEntity>?): List<League> {
        if (entities.isNullOrEmpty()) return emptyList()
        return entities.map { mapToPresentation(it) }
    }

    private fun getDivisionName(division: String?): String {
        if (division.isNullOrEmpty()) return "Unknown"
        return when (division) {
            "0" -> "First Division"
            "1" -> "Second Division"
            "2" -> "Third Division"
            else -> "Unknown"
        }
    }
}