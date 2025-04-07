package com.example.officeroom.ui.rooms

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.officeroom.api.RetrofitClient
import com.example.officeroom.data.DirectoryRepository
import com.example.officeroom.data.Room
import kotlinx.coroutines.launch

class RoomsViewModel : ViewModel() {

    val rooms = MutableLiveData<List<Room>>()
    private val repository = DirectoryRepository(RetrofitClient.instance)

    fun loadRooms() {
        viewModelScope.launch {
            try {
                val roomsList = repository.fetchRooms()
                rooms.value = roomsList
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
