package com.fd.soccer.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_league")
data class LeagueEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val idLeague: String = "",
    @ColumnInfo(name = "league")
    val strLeague: String? = null,
    @ColumnInfo(name = "division")
    val strDivision: String? = null,
    @ColumnInfo(name = "country")
    val strCountry: String? = null,
    @ColumnInfo(name = "current_season")
    val strCurrentSeason: String? = null,
    @ColumnInfo(name = "description")
    val strDescription: String? = null,
    @ColumnInfo(name = "fan_art")
    val strFanArt: String? = null,
    @ColumnInfo(name = "banner")
    val strBanner: String? = null,
    @ColumnInfo(name = "badge")
    val strBadge: String? = null,
    @ColumnInfo(name = "logo")
    val strLogo: String? = null,
    @ColumnInfo(name = "poster")
    val strPoster: String? = null,
    @ColumnInfo(name = "trophy")
    val strTrophy: String? = null,
    @ColumnInfo(name = "cached_at")
    val cachedAt: String? = null,
)