package com.david.nbawatcher.data.repositories

import com.david.nbawatcher.data.mappers.PlayerMapper
import com.david.nbawatcher.data.network.Api
import com.david.nbawatcher.domain.models.Player
import com.david.nbawatcher.domain.repositories.PlayerRepository
import io.reactivex.rxjava3.core.Single

class PlayerDataRepository(
    private val mapper: PlayerMapper,
    private val api: Api
) : PlayerRepository {

    override suspend fun fetchPlayers(): List<Player> {
        val data = api.fetchPlayers().data
        return mapper.invoke(data)
    }

    override fun fetchPlayersSingleRx(): Single<List<Player>> {
        return api.fetchPlayersRxSingle().map { response ->
            mapper.invoke(response.data)
        }
    }
}