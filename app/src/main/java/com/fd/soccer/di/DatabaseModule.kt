package com.fd.soccer.di

import android.app.Application
import androidx.room.Room
import com.fd.soccer.data.local.AppDatabase
import com.fd.soccer.data.local.dao.LeagueDao
import com.fd.soccer.data.local.dao.TeamDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val DatabaseModule = module {

    single { provideDatabase(androidApplication()) }

}

fun provideDatabase(application: Application): AppDatabase {
    return Room.databaseBuilder(application, AppDatabase::class.java, "soccer_db")
        .fallbackToDestructiveMigration()
        .build()
}