package com.sky.architecturedemo.domain.repositories

interface RateMeRepository {

    fun incrementAppHasLaunched()
    fun getAppLaunchCount(): Int
}
