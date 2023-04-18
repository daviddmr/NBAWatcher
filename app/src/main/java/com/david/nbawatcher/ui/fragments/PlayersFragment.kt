package com.david.nbawatcher.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.david.nbawatcher.adapters.PlayersAdapter
import com.david.nbawatcher.databinding.FragmentPlayersBinding
import com.david.nbawatcher.domain.models.Player
import com.david.nbawatcher.viewmodels.PlayersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayersFragment : Fragment() {

    companion object {
        const val TAG = "PlayersFragment"

        fun newInstance() = PlayersFragment()
    }

    private val viewModel: PlayersViewModel by viewModels()
    private lateinit var binding: FragmentPlayersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.playerList.observe(viewLifecycleOwner) {
            setAdapter(it)
        }

        binding.fragmentPlayersBtn.setOnClickListener {
            viewModel.fetchAllPlayers()
        }
    }

    private fun setAdapter(players: List<Player>) {
        val playersAdapter = PlayersAdapter(players)
        binding.fragmentPlayersRv.adapter = playersAdapter
    }
}