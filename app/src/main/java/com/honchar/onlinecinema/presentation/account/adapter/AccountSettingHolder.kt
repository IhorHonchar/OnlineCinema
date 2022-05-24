package com.honchar.onlinecinema.presentation.account.adapter

import com.honchar.onlinecinema.core.base.adapter.Holder
import com.honchar.onlinecinema.core.extensions.setClickListener
import com.honchar.onlinecinema.databinding.SettingItemBinding
import com.honchar.onlinecinema.presentation.account.model.AccountSettingModel
import com.honchar.onlinecinema.presentation.account.model.SettingAction

class AccountSettingHolder(private val onClick: (SettingAction) -> Unit) :
    Holder<AccountSettingModel, SettingItemBinding>() {

    override fun bind(binding: SettingItemBinding, item: AccountSettingModel) {
        binding.ivSettingImage.setImageResource(item.icon)
        binding.tvSettingTitle.text = binding.root.context.getString(item.title)
        binding.root.setClickListener { onClick.invoke(item.action) }
    }
}