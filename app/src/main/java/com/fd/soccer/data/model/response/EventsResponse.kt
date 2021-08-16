package com.fd.soccer.data.model.response


import com.google.gson.annotations.SerializedName

data class EventsResponse(
    @SerializedName("results")
    val results: List<Result>?
)

data class Result(
    @SerializedName("idEvent")
    val idEvent: String?,
    @SerializedName("idSoccerXML")
    val idSoccerXML: Int?,
    @SerializedName("idAPIfootball")
    val idAPIfootball: String?,
    @SerializedName("strEvent")
    val strEvent: String?,
    @SerializedName("strEventAlternate")
    val strEventAlternate: String?,
    @SerializedName("strFilename")
    val strFilename: String?,
    @SerializedName("strSport")
    val strSport: String?,
    @SerializedName("idLeague")
    val idLeague: String?,
    @SerializedName("strLeague")
    val strLeague: String?,
    @SerializedName("strSeason")
    val strSeason: String?,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,
    @SerializedName("strHomeTeam")
    val strHomeTeam: String?,
    @SerializedName("strAwayTeam")
    val strAwayTeam: String?,
    @SerializedName("intHomeScore")
    val intHomeScore: String?,
    @SerializedName("intRound")
    val intRound: String?,
    @SerializedName("intAwayScore")
    val intAwayScore: String?,
    @SerializedName("intSpectators")
    val intSpectators: Int?,
    @SerializedName("strOfficial")
    val strOfficial: String?,
    @SerializedName("strHomeGoalDetails")
    val strHomeGoalDetails: String?,
    @SerializedName("strHomeRedCards")
    val strHomeRedCards: String?,
    @SerializedName("strHomeYellowCards")
    val strHomeYellowCards: String?,
    @SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String?,
    @SerializedName("strHomeLineupDefense")
    val strHomeLineupDefense: String?,
    @SerializedName("strHomeLineupMidfield")
    val strHomeLineupMidfield: String?,
    @SerializedName("strHomeLineupForward")
    val strHomeLineupForward: String?,
    @SerializedName("strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String?,
    @SerializedName("strHomeFormation")
    val strHomeFormation: String?,
    @SerializedName("strAwayRedCards")
    val strAwayRedCards: String?,
    @SerializedName("strAwayYellowCards")
    val strAwayYellowCards: String?,
    @SerializedName("strAwayGoalDetails")
    val strAwayGoalDetails: String?,
    @SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String?,
    @SerializedName("strAwayLineupDefense")
    val strAwayLineupDefense: String?,
    @SerializedName("strAwayLineupMidfield")
    val strAwayLineupMidfield: String?,
    @SerializedName("strAwayLineupForward")
    val strAwayLineupForward: String?,
    @SerializedName("strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String?,
    @SerializedName("strAwayFormation")
    val strAwayFormation: String?,
    @SerializedName("intHomeShots")
    val intHomeShots: Int?,
    @SerializedName("intAwayShots")
    val intAwayShots: Int?,
    @SerializedName("strTimestamp")
    val strTimestamp: String?,
    @SerializedName("dateEvent")
    val dateEvent: String?,
    @SerializedName("dateEventLocal")
    val dateEventLocal: String?,
    @SerializedName("strTime")
    val strTime: String?,
    @SerializedName("strTimeLocal")
    val strTimeLocal: String?,
    @SerializedName("strTVStation")
    val strTVStation: String?,
    @SerializedName("idHomeTeam")
    val idHomeTeam: String?,
    @SerializedName("idAwayTeam")
    val idAwayTeam: String?,
    @SerializedName("strResult")
    val strResult: String?,
    @SerializedName("strVenue")
    val strVenue: String?,
    @SerializedName("strCountry")
    val strCountry: String?,
    @SerializedName("strCity")
    val strCity: String?,
    @SerializedName("strPoster")
    val strPoster: String?,
    @SerializedName("strSquare")
    val strSquare: String?,
    @SerializedName("strFanart")
    val strFanart: String?,
    @SerializedName("strThumb")
    val strThumb: String?,
    @SerializedName("strBanner")
    val strBanner: String?,
    @SerializedName("strMap")
    val strMap: String?,
    @SerializedName("strTweet1")
    val strTweet1: String?,
    @SerializedName("strTweet2")
    val strTweet2: String?,
    @SerializedName("strTweet3")
    val strTweet3: String?,
    @SerializedName("strVideo")
    val strVideo: String?,
    @SerializedName("strStatus")
    val strStatus: String?,
    @SerializedName("strPostponed")
    val strPostponed: String?,
    @SerializedName("strLocked")
    val strLocked: String?
)