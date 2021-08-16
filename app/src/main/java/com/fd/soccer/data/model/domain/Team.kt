package com.fd.soccer.data.model.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    @SerializedName("idTeam")
    val idTeam: String = "",
    @SerializedName("idLeague")
    val idLeague: String = "",
    @SerializedName("intLoved")
    val intLoved: String = "",
    @SerializedName("strTeam")
    val strTeam: String = "",
    @SerializedName("strTeamShort")
    val strTeamShort: String = "",
    @SerializedName("intFormedYear")
    val intFormedYear: String = "",
    @SerializedName("strStadium")
    val strStadium: String = "",
    @SerializedName("strStadiumThumb")
    val strStadiumThumb: String = "",
    @SerializedName("strDescription")
    val strDescription: String = "",
    @SerializedName("strTeamBadge")
    val strTeamBadge: String = "",
    @SerializedName("strTeamJersey")
    val strTeamJersey: String = "",
    @SerializedName("strTeamLogo")
    val strTeamLogo: String = "",
    @SerializedName("strTeamFanArt")
    val strTeamFanArt: String = "",
    @SerializedName("strTeamBanner")
    val strTeamBanner: String = "",
) : Parcelable