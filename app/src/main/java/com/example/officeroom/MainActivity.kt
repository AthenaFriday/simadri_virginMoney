package com.example.officeroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.officeroom.databinding.ActivityMainBinding
import com.example.officeroom.ui.people.PeopleFragment
import com.example.officeroom.ui.rooms.RoomsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PeopleFragment())
                .commit()
        }

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            val selectedFragment = when (menuItem.itemId) {
                R.id.navigation_people -> PeopleFragment()
                R.id.navigation_rooms -> RoomsFragment()
                else -> PeopleFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit()
            true
        }
    }
}
