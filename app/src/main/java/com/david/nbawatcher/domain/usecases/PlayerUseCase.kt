package com.david.nbawatcher.domain.usecases

import com.david.nbawatcher.domain.models.Player
import io.reactivex.rxjava3.core.Single

interface PlayerUseCase {
    suspend fun fetchPlayers(): List<Player>
    fun fetchPlayersRxSingle(): Single<List<Player>>
}