package edu.iesam.pmdm_mayo.features.client.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.pmdm_mayo.R
import edu.iesam.pmdm_mayo.features.client.domain.Client

class ClientAdapter : ListAdapter<Client, ClientViewHolder>(ClientDiffUtil()) {

    private var onDeleteClick: ((Client) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_clients_item, parent, false)
        return ClientViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        onDeleteClick?.let { holder.bind(getItem(position), it) }
    }

    fun setOnDeleteClickListener(listener: (Client) -> Unit) {
        onDeleteClick = listener
    }
}
