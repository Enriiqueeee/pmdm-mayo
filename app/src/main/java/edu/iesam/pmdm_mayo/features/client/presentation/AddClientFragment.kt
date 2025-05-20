package edu.iesam.pmdm_mayo.features.client.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.iesam.pmdm_mayo.databinding.AddClientFragmentBinding
import edu.iesam.pmdm_mayo.features.client.domain.Client
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddClientFragment : Fragment() {

    private var _binding: AddClientFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ClientViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AddClientFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }


    private fun setupViews() {
        binding.btnSave.setOnClickListener {
            val client = Client(
                dni = binding.inputDni.text.toString().toInt(),
                name = binding.inputName.text.toString(),
                email = binding.inputEmail.text.toString()
            )
            viewModel.saveClient(client)
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
