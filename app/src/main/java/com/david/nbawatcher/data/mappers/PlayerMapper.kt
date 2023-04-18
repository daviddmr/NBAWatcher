package com.david.nbawatcher.data.mappers

import com.david.nbawatcher.data.network.models.NWPlayer
import com.david.nbawatcher.domain.models.Player
import javax.inject.Inject

class PlayerMapper @Inject constructor(
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