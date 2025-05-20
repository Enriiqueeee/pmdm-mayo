package edu.iesam.pmdm_mayo.features.client.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import edu.iesam.pmdm_mayo.databinding.ViewClientsItemBinding
import edu.iesam.pmdm_mayo.features.client.domain.Client


class ClientViewHolder(private val view: View): ViewHolder(view) {

    private val binding = ViewClientsItemBinding.bind(view)

    fun bind(client: Client, onDeleteClick: ((Client)) -> Unit){
        binding.apply{
            txtName.text = client.name
            txtDni.text = client.dni.toString()
            txtEmail.text = client.email

            binding.btnDelete.setOnClickListener { onDeleteClick.invoke(client) }

        }
    }

}