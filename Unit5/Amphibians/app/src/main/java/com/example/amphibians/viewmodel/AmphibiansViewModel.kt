package com.example.amphibians.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch

class AmphibiansViewModel : ViewModel() {
    private val _amphibians = MutableLiveData<List<Amphibian>>()
    val amphibians: LiveData<List<Amphibian>> get() = _amphibians

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> get() = _status

    init {
        fetchAmphibians()
    }

    private fun fetchAmphibians() {
        viewModelScope.launch {
            try {
                _amphibians.value = AmphibianApi.retrofitService.getAmphibians()
                _status.value = "Success: Amphibian data retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}