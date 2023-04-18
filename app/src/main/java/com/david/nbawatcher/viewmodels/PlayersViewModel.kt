package com.david.nbawatcher.viewmodels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayersViewModel : ViewModel() {

    private val _playersList = MutableLiveData<String>()

    val playerList: LiveData<String>
        get() = _playersList

    fun updateTitle() {
        Handler(Looper.myLooper()!!).postDelayed({
            _playersList.value = "Text changed"
        }, 3000L)
    }
}