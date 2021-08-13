package com.fd.soccer.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fd.soccer.data.model.entity.LeagueEntity

@Dao
interface LeagueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(league: LeagueEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(leagues: List<LeagueEntity>)

    @Query("SELECT * FROM t_league WHERE country=:country AND cached_at=:currentDate ORDER BY division")
    suspend fun getAll(country: String, currentDate: String): List<LeagueEntity>

}