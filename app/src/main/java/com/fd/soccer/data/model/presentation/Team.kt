package com.fd.soccer.data.model.presentation

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    @SerializedName("team")
    val idTeam: String? = null,
    @SerializedName("idLeague")
    val idLeague: String? = null,
    @SerializedName("loved")
    val intLoved: String? = null,
    @SerializedName("team")
    val strTeam: String? = null,
    @SerializedName("team_short")
    val strTeamShort: String? = null,
    @SerializedName("formed_year")
    val intFormedYear: String? = null,
    @SerializedName("stadium")
    val strStadium: String? = null,
    @SerializedName("stadium_thumb")
    val strStadiumThumb: String? = null,
    @SerializedName("description")
    val strDescription: String? = null,
    @SerializedName("team_badge")
    val strTeamBadge: String? = null,
    @SerializedName("team_jersey")
    val strTeamJersey: String? = null,
    @SerializedName("team_logo")
    val strTeamLogo: String? = null,
    @SerializedName("team_fan_art")
    val strTeamFanArt: String? = null,
    @SerializedName("team_banner")
    val strTeamBanner: String? = null,
) : Parcelable