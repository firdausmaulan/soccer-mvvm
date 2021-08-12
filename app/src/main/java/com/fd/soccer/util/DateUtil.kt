package com.fd.soccer.util

object DateUtil {

    fun getFormattedDate(date : String?) : String{
        if (date.isNullOrEmpty()) return ""
        return date.split("T")[0]
    }

}