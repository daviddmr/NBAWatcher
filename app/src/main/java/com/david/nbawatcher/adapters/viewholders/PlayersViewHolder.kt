package com.david.nbawatcher.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.david.nbawatcher.databinding.ItemPlayerBinding
import com.david.nbawatcher.domain.models.Player

class PlayersViewHolder(private val binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Player) {
        binding.itemPlayerName.text = item.firstName
    }
}