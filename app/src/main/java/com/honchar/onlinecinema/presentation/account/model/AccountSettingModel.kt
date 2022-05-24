package com.honchar.onlinecinema.presentation.account.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AccountSettingModel(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    val action: SettingAction
)

sealed interface SettingAction{
    object Favorite: SettingAction
    object Wishlist: SettingAction
    object Exit: SettingAction
}
