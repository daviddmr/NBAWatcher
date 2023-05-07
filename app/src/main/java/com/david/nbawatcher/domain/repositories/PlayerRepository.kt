package com.david.nbawatcher.domain.repositories

import com.david.nbawatcher.domain.models.Player
import io.reactivex.rxjava3.core.Single

interface PlayerRepository {
    suspend fun fetchPlayers(): List<Player>
    fun fetchPlayersSingleRx(): Single<List<Player>>
}