package com.honchar.onlinecinema.presentation.account.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AccountMenuAdapter:  RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val list = listOf<MenuItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

sealed class MenuItem(open val id: String){
    data class Language(override val id: String): MenuItem(id)
}