package edu.iesam.pmdm_mayo.features.client.presentation

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import edu.iesam.pmdm_mayo.databinding.ViewClientsItemBinding
import edu.iesam.pmdm_mayo.features.client.domain.Client
import edu.iesam.pmdm_mayo.features.client.domain.GetClientsUseCase


class ClientViewHolder(private val view: View): ViewHolder(view) {

    private val binding = ViewClientsItemBinding.bind(view)

    fun bind(client: GetClientsUseCase.ClientFeed, onDeleteClick: ((Client)) -> Unit) {
        binding.apply {
            txtName.text = client.client.name
            txtDni.text = client.client.dni
            txtEmail.text = client.client.email
            Log.d("VIP_VIEW", "DNI: ${client.client.dni} | isVip: ${client.isVip}")
            if (client.isVip) {
                binding.imgVip.visibility = View.VISIBLE
            } else {
                binding.imgVip.visibility = View.GONE
            }
            binding.btnDelete.setOnClickListener { onDeleteClick.invoke(client.client) }
        }
    }
}