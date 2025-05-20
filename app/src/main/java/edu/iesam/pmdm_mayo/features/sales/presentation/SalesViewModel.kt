package edu.iesam.pmdm_mayo.features.sales.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.pmdm_mayo.features.sales.model.GetClientDnisUseCase
import edu.iesam.pmdm_mayo.features.sales.model.Sales
import edu.iesam.pmdm_mayo.features.sales.model.SaveSaleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SalesViewModel(
    private val getClientDnisUseCase: GetClientDnisUseCase,
    private val saveSaleUseCase: SaveSaleUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> get() = _uiState

    fun loadClientDnis() {
        _uiState.value = _uiState.value?.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val dnis = getClientDnisUseCase()
            _uiState.postValue(
                _uiState.value?.copy(
                    dniList = dnis,
                    isLoading = false
                )
            )
        }
    }

    fun saveSale(sale: Sales) {
        viewModelScope.launch(Dispatchers.IO) {
            saveSaleUseCase(sale)
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val dniList: List<String> = emptyList()
    )
}