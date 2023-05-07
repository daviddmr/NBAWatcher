package com.david.nbawatcher.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.nbawatcher.domain.models.Player
import com.david.nbawatcher.domain.usecases.PlayerUseCase
import com.david.nbawatcher.ui.fragments.PlayersFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val playerUseCase: PlayerUseCase
) : ViewModel() {

    private val _playersList = MutableLiveData<List<Player>>()
    private val disposable = CompositeDisposable()

    val playerList: LiveData<List<Player>>
        get() = _playersList

    fun getPlayers() {
        viewModelScope.launch(exceptionHandler()) {
            val result = playerUseCase.fetchPlayers()
            _playersList.value = result
        }
    }

    private fun exceptionHandler() = CoroutineExceptionHandler { coroutineContext, throwable ->
        handleError(throwable)
    }

    private fun handleError(throwable: Throwable) {
        Log.d(PlayersFragment.TAG, "onError: $throwable")
    }

    fun getPlayersRxSingle() {
        disposable.add(
            playerUseCase.fetchPlayersRxSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _playersList.value = it
                }, {
                    handleError(it)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}