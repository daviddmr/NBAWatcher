package com.david.nbawatcher.viewmodels

import com.david.nbawatcher.domain.models.Player
import com.david.nbawatcher.domain.usecases.PlayerUseCase
import com.david.nbawatcher.utils.BaseUnitTest
import com.david.nbawatcher.utils.getValueForTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

internal class PlayersViewModelTest : BaseUnitTest() {

    private val playerUseCase: PlayerUseCase = mock()
    private val playerList: List<Player> = mock()

    @Test
    fun getPlayersShouldCallUseCaseFetchPlayers() {
        runBlocking {
            val sut = PlayersViewModel(playerUseCase)
            sut.getPlayers()
            verify(playerUseCase, times(1)).fetchPlayers()
        }
    }

    @Test
    fun getPlayersShouldReturnANonEmptyListInCaseOfSuccess() {
        runBlocking {
            val sut = mockSuccess()
            sut.getPlayers()
            val result = sut.playerList.getValueForTest()

            assertEquals(playerList, result)
        }
    }

    @Test
    fun getPlayerShouldReturnAnEmptyListInCaseOfError() {
        runBlocking {
            val sut = mockError()
            sut.getPlayers()
            val result = sut.playerList.getValueForTest()
            assertEquals(emptyList<Player>(), result)
        }
    }

    private suspend fun mockSuccess(): PlayersViewModel {
        whenever(playerUseCase.fetchPlayers()).thenReturn(
            playerList
        )
        return PlayersViewModel(playerUseCase)
    }

    private suspend fun mockError(): PlayersViewModel {
        whenever(playerUseCase.fetchPlayers())
            .thenReturn(emptyList())
            .thenThrow(
                RuntimeException("Something went wrong")
            )
        return PlayersViewModel(playerUseCase)
    }

}