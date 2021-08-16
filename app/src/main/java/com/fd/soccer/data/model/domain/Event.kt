package com.fd.soccer.data.model.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    @SerializedName("idEvent")
    val idEvent: String = "",
    @SerializedName("strEvent")
    val strEvent: String = "",
    @SerializedName("strHomeTeam")
    val strHomeTeam: String = "",
    @SerializedName("strAwayTeam")
    val strAwayTeam: String = "",
    @SerializedName("intHomeScore")
    val intHomeScore: String = "",
    @SerializedName("intAwayScore")
    val intAwayScore: String = "",
    @SerializedName("strTimestamp")
    val strTimestamp: String = "",
    @SerializedName("dateEvent")
    val dateEvent: String = "",
    @SerializedName("strTime")
    val strTime: String = "",
    @SerializedName("idHomeTeam")
    val idHomeTeam: String = "",
    @SerializedName("idAwayTeam")
    val idAwayTeam: String = "",
    @SerializedName("strScoreResult")
    val strScoreResult: String = "",
    @SerializedName("dateTime")
    val dateTime: String = ""
) : Parcelable