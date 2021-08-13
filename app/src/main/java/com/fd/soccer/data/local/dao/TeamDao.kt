package com.fd.soccer.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fd.soccer.data.model.entity.TeamEntity

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(team: TeamEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(teams: List<TeamEntity>)

    @Query("SELECT * FROM t_team WHERE id_league=:idLeague AND cached_at=:currentDate ORDER BY team")
    suspend fun getAll(idLeague: String, currentDate: String): List<TeamEntity>

}