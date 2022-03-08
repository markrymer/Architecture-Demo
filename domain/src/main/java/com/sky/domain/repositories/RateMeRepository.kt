package com.sky.domain.repositories

interface RateMeRepository {

    fun incrementAppHasLaunched()
    fun getAppLaunchCount(): Int
}
