package com.david.nbawatcher.domain.usecases

import com.david.nbawatcher.domain.models.Player
import com.david.nbawatcher.domain.repositories.PlayerRepository

class PlayerUseCaseImpl(
    private val repository: PlayerRepository
) : PlayerUseCase {
    override suspend fun fetchPlayers(): List<Player> {
        return repository.fetchPlayers()
    }
}