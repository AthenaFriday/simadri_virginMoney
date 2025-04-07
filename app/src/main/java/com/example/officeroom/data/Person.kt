package com.example.officeroom.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val jobtitle: String,
    val favouriteColor: String,
    val avatar: String,
    val createdAt: String
) : Parcelable
