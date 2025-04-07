package com.example.officeroom.ui.people

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.officeroom.databinding.ActivityPersonDetailBinding
import java.text.SimpleDateFormat
import java.util.Locale

class PersonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarPeopleDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbarPeopleDetail.setNavigationOnClickListener {
            finish()
        }

        // Retrieve data passed via Intent extras
        val avatarUrl = intent.getStringExtra("avatarUrl") ?: ""
        val firstName = intent.getStringExtra("firstName") ?: "FirstName"
        val lastName = intent.getStringExtra("lastName") ?: "LastName"
        val jobTitle = intent.getStringExtra("jobTitle") ?: "Job Title"
        val email = intent.getStringExtra("email") ?: "email@example.com"
        val createdAt = intent.getStringExtra("createdAt") ?: "2022-01-24T17:02:23.729Z"
        val favoriteColor = intent.getStringExtra("favoriteColor") ?: "Favorite Color"

        displayPersonDetails(avatarUrl, firstName, lastName, jobTitle, email, createdAt, favoriteColor)
    }

    private fun displayPersonDetails(
        avatarUrl: String,
        firstName: String,
        lastName: String,
        jobTitle: String,
        email: String,
        createdAt: String,
        favoriteColor: String
    ) {
        Glide.with(this)
            .load(avatarUrl)
            .into(binding.imageViewAvatarDetail)

        binding.textViewNameDetail.text = "$firstName $lastName"
        binding.textViewJobTitleDetail.text = jobTitle

        binding.textViewEmailDetail.text = email

        binding.textViewJobTitleAdditional.text = jobTitle
        binding.textViewFavoriteColor.text = favoriteColor

        binding.textViewJoinedDate.text = formatDate(createdAt)
    }

    private fun formatDate(isoDate: String): String {
        return try {
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val date = parser.parse(isoDate)
            val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
            date?.let { formatter.format(it) } ?: isoDate
        } catch (e: Exception) {
            isoDate
        }
    }
}
