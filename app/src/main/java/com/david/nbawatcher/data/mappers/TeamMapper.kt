package com.david.nbawatcher.data.mappers

import com.david.nbawatcher.data.network.models.NWTeam
import com.david.nbawatcher.domain.models.Team
import javax.inject.Inject

class TeamMapper @Inject constructor() : Function1<NWTeam?, Team?> {
    override fun invoke(nwTeam: NWTeam?): Team? {
        return nwTeam?.let {
            Team(
                it.id,
                it.abbreviation,
                it.city,
                it.conference,
                it.division,
                it.fullName,
                it.name
            )
        }
    }
}