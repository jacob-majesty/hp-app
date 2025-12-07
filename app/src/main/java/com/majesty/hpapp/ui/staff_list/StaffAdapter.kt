package com.majesty.hpapp.ui.staff_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.majesty.hpapp.R
import com.majesty.hpapp.data.model.Character

class StaffAdapter(private var staffList: List<Character>) :
    RecyclerView.Adapter<StaffAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textViewCharacterName)
        val house: TextView = view.findViewById(R.id.textViewCharacterHouse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = staffList[position]
        holder.name.text = character.name
        holder.house.text = "Casa: ${character.house ?: "N/A"}"
    }

    override fun getItemCount(): Int = staffList.size

    fun updateList(newList: List<Character>) {
        staffList = newList
        notifyDataSetChanged()
    }
}