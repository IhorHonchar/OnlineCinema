package com.honchar.onlinecinema.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter

class EndlessAdapter: BaseViewBindingAdapter() {
    override fun getItemCount() = Integer.MAX_VALUE

    override fun getItemViewType(position: Int): Int {
        val positionInList = position % items.size
        return entities[items[positionInList]::class.java] ?: super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val positionInList = position % items.size
        bind(holder, items[positionInList])
    }
}