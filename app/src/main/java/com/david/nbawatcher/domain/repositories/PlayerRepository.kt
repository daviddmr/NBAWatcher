package com.david.nbawatcher.domain.repositories

import com.david.nbawatcher.domain.models.Player

interface PlayerRepository {
    suspend fun fetchPlayers(): List<Player>
}