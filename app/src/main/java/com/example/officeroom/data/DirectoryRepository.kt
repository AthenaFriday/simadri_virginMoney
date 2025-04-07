package com.example.officeroom.data

import com.example.officeroom.api.ApiService

class DirectoryRepository(private val apiService: ApiService) {

    suspend fun fetchPeople() = apiService.getPeople()

    suspend fun fetchRooms() = apiService.getRooms()
}