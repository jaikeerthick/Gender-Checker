package com.jaikeerthick.genderchecker.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaikeerthick.genderchecker.repository.MainRepository
import com.jaikeerthick.genderchecker.ui.model.GenderResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {


    val _response : MutableLiveData<GenderResponse> = MutableLiveData()


    fun getGender(username: String){

        viewModelScope.launch {
            _response.postValue(repository.getGender(username))
        }

    }

}