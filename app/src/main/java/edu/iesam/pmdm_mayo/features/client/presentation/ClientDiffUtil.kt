package edu.iesam.pmdm_mayo.features.client.presentation

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import edu.iesam.pmdm_mayo.features.client.domain.Client

class ClientDiffUtil: DiffUtil.ItemCallback<Client>() {
    override fun areItemsTheSame(oldItem: Client, newItem: Client): Boolean {
        return oldItem.dni == newItem.dni
    }

    override fun areContentsTheSame(oldItem: Client, newItem: Client): Boolean {
        return oldItem == newItem
    }
}