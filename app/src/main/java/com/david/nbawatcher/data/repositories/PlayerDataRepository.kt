package com.david.nbawatcher.data.repositories

import com.david.nbawatcher.data.mappers.PlayerMapper
import com.david.nbawatcher.data.network.Api
import com.david.nbawatcher.domain.models.Player
import com.david.nbawatcher.domain.repositories.PlayerRepository

class PlayerDataRepository(
    private val api: Api,
    private val mapper: PlayerMapper
) : PlayerRepository {

    override suspend fun fetchPlayers(): List<Player> {
        val data = api.fetchPlayers().data
        return mapper.invoke(data)
    }
}