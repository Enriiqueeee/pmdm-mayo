package edu.iesam.pmdm_mayo.features.client.presentation

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import edu.iesam.pmdm_mayo.features.client.domain.Client
import edu.iesam.pmdm_mayo.features.client.domain.GetClientsUseCase

class ClientDiffUtil: DiffUtil.ItemCallback<GetClientsUseCase.ClientFeed>() {
    override fun areItemsTheSame(
        oldItem: GetClientsUseCase.ClientFeed,
        newItem: GetClientsUseCase.ClientFeed
    ): Boolean {
        return oldItem.client.dni == newItem.client.dni
    }

    override fun areContentsTheSame(
        oldItem: GetClientsUseCase.ClientFeed,
        newItem: GetClientsUseCase.ClientFeed
    ): Boolean {
        return oldItem == newItem
    }

}