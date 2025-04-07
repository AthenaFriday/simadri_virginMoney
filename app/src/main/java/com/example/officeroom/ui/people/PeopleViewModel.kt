package com.example.officeroom.ui.people

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.officeroom.api.RetrofitClient
import com.example.officeroom.data.DirectoryRepository
import com.example.officeroom.data.Person
import kotlinx.coroutines.launch

class PeopleViewModel : ViewModel() {

    val people = MutableLiveData<List<Person>>()
    private val repository = DirectoryRepository(RetrofitClient.instance)

    fun loadPeople() {
        viewModelScope.launch {
            try {
                val peopleList = repository.fetchPeople()
                people.value = peopleList
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
