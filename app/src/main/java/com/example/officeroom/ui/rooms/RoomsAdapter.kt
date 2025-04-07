package com.example.officeroom.ui.rooms

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.officeroom.data.Room
import com.example.officeroom.databinding.ItemRoomBinding

class RoomsAdapter : ListAdapter<Room, RoomsAdapter.RoomViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Room>() {
            override fun areItemsTheSame(oldItem: Room, newItem: Room): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Room, newItem: Room): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class RoomViewHolder(private val binding: ItemRoomBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(room: Room) {
            binding.textViewMaxOccupancy.text = "Max Occupancy: ${room.maxOccupancy}"

            if (room.isOccupied) {
                binding.textViewRoomStatus.text = "Occupied"
                binding.textViewRoomStatus.setTextColor(Color.RED)
            } else {
                binding.textViewRoomStatus.text = "Available"
                binding.textViewRoomStatus.setTextColor(Color.parseColor("#388E3C"))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
