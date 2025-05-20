package edu.iesam.pmdm_mayo.features.client.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.pmdm_mayo.databinding.ClientFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientFragment : Fragment() {

    private var _binding: ClientFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ClientViewModel by viewModel()
    private val adapter = ClientAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ClientFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
        viewModel.loadClient()
    }

    private fun setupViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        adapter.setOnDeleteClickListener { client ->
            viewModel.deleteClient(client)
        }
    }

    private fun setupObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            if (state.isLoading) {
            } else {
                adapter.submitList(state.client)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
