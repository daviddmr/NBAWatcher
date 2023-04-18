package com.david.nbawatcher.di.modules

import com.david.nbawatcher.data.mappers.PlayerMapper
import com.david.nbawatcher.data.network.Api
import com.david.nbawatcher.data.repositories.PlayerDataRepository
import com.david.nbawatcher.domain.repositories.PlayerRepository
import com.david.nbawatcher.domain.usecases.PlayerUseCase
import com.david.nbawatcher.domain.usecases.PlayerUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(
    ViewModelComponent::class
)
class PlayerModule {

    @Provides
    fun providePlayerUseCase(playerRepository: PlayerRepository): PlayerUseCase =
        PlayerUseCaseImpl(playerRepository)

    @Provides
    fun providePlayerRepository(playerMapper: PlayerMapper, api: Api): PlayerRepository =
        PlayerDataRepository(playerMapper, api)
}