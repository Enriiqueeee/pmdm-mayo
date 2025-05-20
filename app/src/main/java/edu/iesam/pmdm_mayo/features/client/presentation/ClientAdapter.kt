package edu.iesam.pmdm_mayo.features.client.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.pmdm_mayo.R
import edu.iesam.pmdm_mayo.features.client.domain.Client
import edu.iesam.pmdm_mayo.features.client.domain.GetClientsUseCase

class ClientAdapter : ListAdapter<GetClientsUseCase.ClientFeed, ClientViewHolder>(ClientDiffUtil()) {

    private var onDeleteClick: ((Client) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_clients_item, parent, false)
        return ClientViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val item = getItem(position)
        onDeleteClick?.let { holder.bind(item, it) }
    }


    fun setOnDeleteClickListener(listener: (Client) -> Unit) {
        onDeleteClick = listener
    }

}
