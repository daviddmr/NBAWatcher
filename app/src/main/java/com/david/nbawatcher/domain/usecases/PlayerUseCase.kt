package com.david.nbawatcher.domain.usecases

import com.david.nbawatcher.domain.models.Player

interface PlayerUseCase {
    suspend fun fetchPlayers(): List<Player>
}