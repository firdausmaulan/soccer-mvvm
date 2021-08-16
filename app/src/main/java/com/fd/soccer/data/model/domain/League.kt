package com.fd.soccer.data.model.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class League(
    @SerializedName("idLeague")
    val idLeague: String = "",
    @SerializedName("strLeague")
    val strLeague: String = "",
    @SerializedName("strDivision")
    val strDivision: String = "",
    @SerializedName("strCountry")
    val strCountry: String = "",
    @SerializedName("strCurrentSeason")
    val strCurrentSeason: String = "",
    @SerializedName("strDescription")
    val strDescription: String = "",
    @SerializedName("strFanArt")
    val strFanArt: String = "",
    @SerializedName("strBanner")
    val strBanner: String = "",
    @SerializedName("strBadge")
    val strBadge: String = "",
    @SerializedName("strLogo")
    val strLogo: String = "",
    @SerializedName("strPoster")
    val strPoster: String = "",
    @SerializedName("strTrophy")
    val strTrophy: String = "",
) : Parcelable