package com.david.nbawatcher.domain.usecases

import com.david.nbawatcher.domain.models.Player
import com.david.nbawatcher.domain.repositories.PlayerRepository
import io.reactivex.rxjava3.core.Single

class PlayerUseCaseImpl(
    private val repository: PlayerRepository
) : PlayerUseCase {
    override suspend fun fetchPlayers(): List<Player> {
        return repository.fetchPlayers()
    }

    override fun fetchPlayersRxSingle(): Single<List<Player>> {
        return repository.fetchPlayersSingleRx()
    }
}