package com.example.officeroom.data

data class Room(
    val id: String,
    val createdAt: String,
    val isOccupied: Boolean,
    val maxOccupancy: Int
)
