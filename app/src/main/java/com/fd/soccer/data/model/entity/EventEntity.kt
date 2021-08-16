package com.fd.soccer.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_event")
data class EventEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id_event")
    val idEvent: String = "",
    @ColumnInfo(name = "event")
    val strEvent: String? = null,
    @ColumnInfo(name = "home_team")
    val strHomeTeam: String? = null,
    @ColumnInfo(name = "away_team")
    val strAwayTeam: String? = null,
    @ColumnInfo(name = "home_score")
    val intHomeScore: String? = null,
    @ColumnInfo(name = "away_score")
    val intAwayScore: String? = null,
    @ColumnInfo(name = "timestamp")
    val strTimestamp: String? = null,
    @ColumnInfo(name = "date_event")
    val dateEvent: String? = null,
    @ColumnInfo(name = "time")
    val strTime: String? = null,
    @ColumnInfo(name = "id_home_team")
    val idHomeTeam: String? = null,
    @ColumnInfo(name = "id_away_team")
    val idAwayTeam: String? = null,
    @ColumnInfo(name = "cached_at")
    val cachedAt: String? = null
)