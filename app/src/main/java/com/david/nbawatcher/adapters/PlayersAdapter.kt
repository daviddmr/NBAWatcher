package com.david.nbawatcher.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.david.nbawatcher.adapters.viewholders.PlayersViewHolder
import com.david.nbawatcher.databinding.ItemPlayerBinding
import com.david.nbawatcher.domain.models.Player

class PlayersAdapter(private val list: List<Player>) :
    RecyclerView.Adapter<PlayersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersViewHolder {
        return PlayersViewHolder(
            ItemPlayerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PlayersViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }
}