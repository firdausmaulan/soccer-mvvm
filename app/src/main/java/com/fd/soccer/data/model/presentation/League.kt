package com.fd.soccer.data.model.presentation

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class League(
    @SerializedName("id")
    val idLeague: String? = null,
    @SerializedName("league")
    val strLeague: String? = null,
    @SerializedName("division")
    val strDivision: String? = null,
    @SerializedName("country")
    val strCountry: String? = null,
    @SerializedName("current_season")
    val strCurrentSeason: String? = null,
    @SerializedName("description")
    val strDescription: String? = null,
    @SerializedName("fan_art")
    val strFanArt: String? = null,
    @SerializedName("banner")
    val strBanner: String? = null,
    @SerializedName("badge")
    val strBadge: String? = null,
    @SerializedName("logo")
    val strLogo: String? = null,
    @SerializedName("poster")
    val strPoster: String? = null,
    @SerializedName("trophy")
    val strTrophy: String? = null,
) : Parcelable