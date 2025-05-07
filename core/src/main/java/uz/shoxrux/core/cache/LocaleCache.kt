package uz.shoxrux.core.cache

import android.content.SharedPreferences
import javax.inject.Inject
import androidx.core.content.edit

class LocaleCache @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    private val isFirstKey = "IS_FIRST_KEY"

    fun saveIsNotFirst() {
        sharedPreferences.edit { putBoolean(isFirstKey, false) }
    }

    fun isFirst(): Boolean {
        return sharedPreferences.getBoolean(isFirstKey, true)
    }

}