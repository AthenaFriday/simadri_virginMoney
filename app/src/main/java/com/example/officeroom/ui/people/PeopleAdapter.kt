package com.example.officeroom.ui.people

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.officeroom.data.Person
import com.example.officeroom.databinding.ItemPersonBinding
import com.example.officeroom.ui.people.PersonDetailActivity

class PeopleAdapter : ListAdapter<Person, PeopleAdapter.PersonViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((Person, Int) -> Unit)? = null

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Person>() {
            override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class PersonViewHolder(private val binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person, position: Int) {
            binding.textViewName.text = "${position + 1}. ${person.firstName} ${person.lastName}"
            binding.textViewEmail.text = person.email
            binding.textViewJobTitle.text = person.jobtitle

            Glide.with(binding.imageViewAvatar.context)
                .load(person.avatar)
                .into(binding.imageViewAvatar)

            binding.root.setOnClickListener {
                onItemClick?.invoke(person, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
}
