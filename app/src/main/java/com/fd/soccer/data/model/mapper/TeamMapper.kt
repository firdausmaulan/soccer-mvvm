package com.fd.soccer.data.model.mapper

import com.fd.soccer.data.model.entity.TeamEntity
import com.fd.soccer.data.model.domain.Team
import com.fd.soccer.util.Constant
import com.fd.soccer.util.DateUtil

class TeamMapper {

    fun mapToEntity(team: com.fd.soccer.data.model.response.Team): TeamEntity {
        return TeamEntity(
            idTeam = team.idTeam ?: "",
            idLeague = team.idLeague,
            intLoved = team.intLoved,
            strTeam = team.strTeam,
            strTeamShort = team.strTeamShort,
            intFormedYear = team.intFormedYear,
            strStadium = team.strStadium,
            strStadiumThumb = team.strStadiumThumb,
            strDescription = team.strDescriptionEN,
            strTeamBadge = team.strTeamBadge,
            strTeamJersey = team.strTeamJersey,
            strTeamLogo = team.strTeamLogo,
            strTeamFanArt = team.strTeamFanart1,
            strTeamBanner = team.strTeamBanner,
            cachedAt = DateUtil.getCurrentDate()
        )
    }

    fun mapToEntity(teams: List<com.fd.soccer.data.model.response.Team>?): List<TeamEntity> {
        if (teams.isNullOrEmpty()) return emptyList()
        return teams.map { mapToEntity(it) }
    }

    fun mapToDomain(entity: TeamEntity): Team {
        return Team(
            idTeam = entity.idTeam,
            idLeague = entity.idLeague ?: "",
            intLoved = entity.intLoved ?: "",
            strTeam = entity.strTeam ?: "",
            strTeamShort = entity.strTeamShort ?: "",
            intFormedYear = entity.intFormedYear ?: "",
            strStadium = entity.strStadium ?: "",
            strStadiumThumb = entity.strStadiumThumb + Constant.PREVIEW_IMG,
            strDescription = entity.strDescription ?: "",
            strTeamBadge = entity.strTeamBadge + Constant.PREVIEW_IMG,
            strTeamJersey = entity.strTeamJersey + Constant.PREVIEW_IMG,
            strTeamLogo = entity.strTeamLogo + Constant.PREVIEW_IMG,
            strTeamFanArt = entity.strTeamFanArt + Constant.PREVIEW_IMG,
            strTeamBanner = entity.strTeamBanner + Constant.PREVIEW_IMG,
        )
    }

    fun mapToDomain(entities: List<TeamEntity>?): List<Team> {
        if (entities.isNullOrEmpty()) return emptyList()
        return entities.map { mapToDomain(it) }
    }
}