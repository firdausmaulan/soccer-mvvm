package com.fd.soccer.ui.teams

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fd.soccer.data.model.mapper.TeamMapper
import com.fd.soccer.data.model.domain.Team
import com.fd.soccer.data.model.request.TeamsRequest
import com.fd.soccer.data.repository.team.TeamRepository
import com.fd.soccer.util.State
import com.fd.soccer.util.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeamsViewModel(
    private val teamRepository: TeamRepository,
    private val teamMapper: TeamMapper
) : ViewModel() {

    val teamsLiveData = MutableLiveData<State<List<Team>>>()

    fun fetchTeams(request: TeamsRequest) {
        viewModelScope.launch {
            teamsLiveData.postValue(State.loading())
            val result = withContext(Dispatchers.IO) { teamRepository.getTeams(request) }
            if (result.status == Status.SUCCESS) {
                val teams = teamMapper.mapToDomain(result.data)
                teamsLiveData.postValue(State.success(teams))
            } else {
                teamsLiveData.postValue(State.error(result.throwable))
            }
        }
    }

}