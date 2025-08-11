package uz.shoxrux.core.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun String.toHumanDate(): String {
    return try {
        val parser = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formatter = SimpleDateFormat("d MMMM yyyy", Locale("ru"))
        val date = parser.parse(this)
        formatter.format(date ?: return this)
    } catch (e: Exception) {
        this
    }
}