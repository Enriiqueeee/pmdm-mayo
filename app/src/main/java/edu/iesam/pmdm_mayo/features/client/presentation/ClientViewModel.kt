package edu.iesam.pmdm_mayo.features.client.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.pmdm_mayo.features.client.domain.Client
import edu.iesam.pmdm_mayo.features.client.domain.DeleteClientUseCase
import edu.iesam.pmdm_mayo.features.client.domain.GetClientsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ClientViewModel(private val getClientsUseCase: GetClientsUseCase, private val deleteClientUseCase: DeleteClientUseCase): ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> get() = _uiState

    fun loadClient(){
        _uiState.value = _uiState.value?.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO){
            val client = getClientsUseCase.invoke()
            _uiState.postValue(
                UiState(
                    client = client,
                    errorApp = false
                )
            )
        }
    }

    fun deleteClient(client: Client) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteClientUseCase(client)
            loadClient()
        }
    }


    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: Boolean = false,
        val client: List<Client> = emptyList()
    )
}