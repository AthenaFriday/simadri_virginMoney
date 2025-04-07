package com.example.officeroom.ui.people

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.officeroom.data.Person
import com.example.officeroom.databinding.ActivityPersonDetailBinding

class PersonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val person = intent.getParcelableExtra<Person>("person")
        person?.let {
            binding.textViewName.text = "${it.firstName} ${it.lastName}"
            binding.textViewEmail.text = it.email
            binding.textViewJobTitle.text = it.jobtitle
            binding.textViewFavouriteColor.text = "Favourite Color: ${it.favouriteColor}"

            Glide.with(this)
                .load(it.avatar)
                .into(binding.imageViewAvatar)
        }
    }
}
