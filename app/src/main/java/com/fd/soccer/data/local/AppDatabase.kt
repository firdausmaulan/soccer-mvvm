package com.fd.soccer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fd.soccer.data.local.dao.LeagueDao
import com.fd.soccer.data.local.dao.TeamDao
import com.fd.soccer.data.model.entity.LeagueEntity
import com.fd.soccer.data.model.entity.TeamEntity

@Database(
    entities = [LeagueEntity::class, TeamEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun leagueDao(): LeagueDao

    abstract fun teamDao(): TeamDao

}