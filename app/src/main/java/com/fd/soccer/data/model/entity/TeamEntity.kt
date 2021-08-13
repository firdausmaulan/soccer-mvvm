package com.fd.soccer.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_team")
data class TeamEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val idTeam: String = "",
    @ColumnInfo(name = "id_league")
    val idLeague: String? = null,
    @ColumnInfo(name = "loved")
    val intLoved: String? = null,
    @ColumnInfo(name = "team")
    val strTeam: String? = null,
    @ColumnInfo(name = "team_short")
    val strTeamShort: String? = null,
    @ColumnInfo(name = "formed_year")
    val intFormedYear: String? = null,
    @ColumnInfo(name = "stadium")
    val strStadium: String? = null,
    @ColumnInfo(name = "stadium_thumb")
    val strStadiumThumb: String? = null,
    @ColumnInfo(name = "description")
    val strDescription: String? = null,
    @ColumnInfo(name = "team_badge")
    val strTeamBadge: String? = null,
    @ColumnInfo(name = "team_jersey")
    val strTeamJersey: String? = null,
    @ColumnInfo(name = "team_logo")
    val strTeamLogo: String? = null,
    @ColumnInfo(name = "team_fan_art")
    val strTeamFanArt: String? = null,
    @ColumnInfo(name = "team_banner")
    val strTeamBanner: String? = null,
    @ColumnInfo(name = "cached_at")
    val cachedAt: String? = null,
)