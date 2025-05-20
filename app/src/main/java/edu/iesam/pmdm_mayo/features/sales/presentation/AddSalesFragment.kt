package edu.iesam.pmdm_mayo.features.sales.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.iesam.pmdm_mayo.databinding.AddSaleFragmentBinding
import edu.iesam.pmdm_mayo.features.sales.model.Sales
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddSaleFragment : Fragment() {

    private var _binding: AddSaleFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SalesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AddSaleFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        observeViewModel()
        viewModel.loadClientDnis()
    }

    private fun setupListeners() {
        binding.btnSaveSale.setOnClickListener {
            val dni = binding.spinnerDni.selectedItem as String
            val concept = binding.inputConcept.text.toString()
            val total = binding.inputTotal.text.toString().toDoubleOrNull() ?: 0.0

            val sale = Sales(dni = dni, conceptSales = concept, totalSales = total)
            viewModel.saveSale(sale)
            findNavController().popBackStack()
        }

        binding.btnBackSale.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observeViewModel() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, state.dniList)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerDni.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
