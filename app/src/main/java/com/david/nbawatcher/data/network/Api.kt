package com.david.nbawatcher.data.network

import com.david.nbawatcher.data.network.models.NWPlayerListResponse
import retrofit2.http.GET

interface Api {

    //Player
    @GET("players")
    suspend fun fetchPlayers() : NWPlayerListResponse
}