package com.example.officeroom.api

import com.example.officeroom.data.Person
import com.example.officeroom.data.Room
import retrofit2.http.GET

interface ApiService {
    @GET("people")
    suspend fun getPeople(): List<Person>

    @GET("rooms")
    suspend fun getRooms(): List<Room>
}
