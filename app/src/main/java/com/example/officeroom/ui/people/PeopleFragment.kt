package com.example.officeroom.ui.people

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.officeroom.databinding.FragmentPeopleBinding
import com.example.officeroom.ui.people.PersonDetailActivity

class PeopleFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PeopleViewModel
    private lateinit var peopleAdapter: PeopleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[PeopleViewModel::class.java]

        binding.peopleRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        peopleAdapter = PeopleAdapter()
        binding.peopleRecyclerView.adapter = peopleAdapter

        // Set the onItemClick callback
        peopleAdapter.onItemClick = { person, position ->
            val intent = Intent(requireContext(), PersonDetailActivity::class.java).apply {
                putExtra("avatarUrl", person.avatar)
                putExtra("firstName", person.firstName)
                putExtra("lastName", person.lastName)
                putExtra("jobTitle", person.jobtitle)
                putExtra("email", person.email)
                putExtra("createdAt", person.createdAt)
                putExtra("favoriteColor", person.favoriteColor)
            }
            startActivity(intent)
        }


        viewModel.people.observe(viewLifecycleOwner) { peopleList ->
            peopleAdapter.submitList(peopleList)
        }
        viewModel.loadPeople()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
