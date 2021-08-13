package com.fd.soccer.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(Date())
    }

}