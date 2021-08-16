package com.fd.soccer.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fd.soccer.data.model.entity.EventEntity

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: EventEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(events: List<EventEntity>)

    @Query("SELECT * FROM t_event WHERE id_home_team=:idHomeTeam AND cached_at=:currentDate ORDER BY timestamp DESC")
    suspend fun getAll(idHomeTeam: String, currentDate: String): List<EventEntity>

}