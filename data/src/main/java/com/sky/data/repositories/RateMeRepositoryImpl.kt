package com.sky.data.repositories

import android.content.SharedPreferences
import com.sky.domain.repositories.RateMeRepository
import javax.inject.Inject

const val LAUNCH_COUNT_KEY = "launch_count"

class RateMeRepositoryImpl
@Inject constructor(
    private val sharedPreferences: SharedPreferences
) : RateMeRepository {

    override fun incrementAppHasLaunched() {
        val currentLaunchCount = getAppLaunchCount()
        sharedPreferences
            .edit()
            .putInt(LAUNCH_COUNT_KEY, currentLaunchCount + 1)
            .apply()
    }

    override fun getAppLaunchCount(): Int {
        return sharedPreferences.getInt(LAUNCH_COUNT_KEY, 0)
    }
}
