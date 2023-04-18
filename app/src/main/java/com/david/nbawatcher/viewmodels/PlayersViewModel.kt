package com.david.nbawatcher.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.nbawatcher.data.mappers.PlayerMapper
import com.david.nbawatcher.data.mappers.TeamMapper
import com.david.nbawatcher.domain.models.Player
import com.david.nbawatcher.data.network.Api
import com.david.nbawatcher.data.repositories.PlayerDataRepository
import com.david.nbawatcher.ui.fragments.PlayersFragment
import com.david.nbawatcher.domain.usecases.PlayerUseCaseImpl
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlayersViewModel(
//    private val playerUseCase: PlayerUserCase
    ) : ViewModel() {

    private val _playersList = MutableLiveData<List<Player>>()

    val playerList: LiveData<List<Player>>
        get() = _playersList

    var logging: HttpLoggingInterceptor? = null

    init {
        logging = HttpLoggingInterceptor()
        logging!!.level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging!!)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .client(httpClient)
        .baseUrl("https://balldontlie.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(Api::class.java)

    private val teamMapper = TeamMapper()
    private val mapper = PlayerMapper(teamMapper)
    private val repository = PlayerDataRepository(api, mapper)

    private val playerUseCase = PlayerUseCaseImpl(repository)
    fun fetchAllPlayers() {

        viewModelScope.launch(exceptionHandler()) {
            val result = playerUseCase.fetchPlayers()
            _playersList.value = result
        }
    }

    private fun exceptionHandler() = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d(PlayersFragment.TAG, "onError: $throwable")
    }
}