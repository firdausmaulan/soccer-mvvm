package com.fd.soccer.ui.leagues

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fd.soccer.data.model.mapper.LeagueMapper
import com.fd.soccer.data.model.domain.League
import com.fd.soccer.data.model.request.LeaguesRequest
import com.fd.soccer.data.repository.league.LeagueRepository
import com.fd.soccer.util.Constant
import com.fd.soccer.util.State
import com.fd.soccer.util.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LeaguesViewModel(
    private val leagueRepository: LeagueRepository,
    private val leagueMapper: LeagueMapper
) : ViewModel() {

    val leaguesLiveData = MutableLiveData<State<List<League>>>()

    fun fetchLeagues(request: LeaguesRequest) {
        viewModelScope.launch {
            leaguesLiveData.postValue(State.loading())
            val result = withContext(Dispatchers.IO) { leagueRepository.getLeagues(request) }
            if (result.status == Status.SUCCESS) {
                val leagues = leagueMapper.mapToDomain(result.data)
                leaguesLiveData.postValue(State.success(leagues))
            } else {
                leaguesLiveData.postValue(State.error(result.throwable))
            }
        }
    }

}