package com.david.nbawatcher.data.network

import com.david.nbawatcher.data.network.models.NWPlayerListResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface Api {

    //Player
    @GET("players")
    suspend fun fetchPlayers() : NWPlayerListResponse

    @GET("players")
    fun fetchPlayersRxSingle(): Single<NWPlayerListResponse>
}