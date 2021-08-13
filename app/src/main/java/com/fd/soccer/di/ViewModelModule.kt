package com.fd.soccer.di

import com.fd.soccer.ui.leagues.LeaguesViewModel
import com.fd.soccer.ui.teams.TeamsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {

    viewModel { LeaguesViewModel(get(), get()) }

    viewModel { TeamsViewModel(get(), get()) }

}