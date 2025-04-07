package com.example.officeroom.ui.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.officeroom.databinding.FragmentRoomsBinding

class RoomsFragment : Fragment() {

    private var _binding: FragmentRoomsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RoomsViewModel
    private lateinit var roomsAdapter: RoomsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RoomsViewModel::class.java]

        binding.roomsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        roomsAdapter = RoomsAdapter()
        binding.roomsRecyclerView.adapter = roomsAdapter

        viewModel.rooms.observe(viewLifecycleOwner, Observer { roomsList ->
            roomsAdapter.submitList(roomsList)
        })

        viewModel.loadRooms()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
