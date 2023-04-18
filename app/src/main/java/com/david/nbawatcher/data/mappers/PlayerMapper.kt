package com.david.nbawatcher.data.mappers

import com.david.nbawatcher.data.network.models.NWPlayer
import com.david.nbawatcher.domain.models.Player

class PlayerMapper(
    private val teamMapper: TeamMapper
) : Function1<List<NWPlayer>?, List<Player>> {
    override fun invoke(nwPlayerList: List<NWPlayer>?): List<Player> {
        return nwPlayerList?.let { list ->
            list.map {
                Player(
                    it.id,
                    it.firstName,
                    it.heightFeet,
                    it.heightInches,
                    it.lastName,
                    it.position,
                    teamMapper.invoke(it.team),
                    it.weightPounds
                )
            }
        } ?: emptyList()
    }
}