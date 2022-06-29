package com.honchar.onlinecinema.presentation.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.presentation.BaseViewModel
import com.honchar.onlinecinema.presentation.FilmsFactory
import com.honchar.onlinecinema.presentation.account.model.AccountSettingModel
import com.honchar.onlinecinema.presentation.account.model.SettingAction
import com.honchar.onlinecinema.presentation.account.model.UserDataModel

abstract class AccountViewModel : BaseViewModel() {
    abstract val settingsLiveData: LiveData<List<AccountSettingModel>>
    abstract val userDataLiveData: LiveData<UserDataModel>

    abstract fun getSettingsList()
    abstract fun getUserData()
}

class AccountViewModelImpl : AccountViewModel() {
    override val settingsLiveData = MutableLiveData<List<AccountSettingModel>>()
    override val userDataLiveData = MutableLiveData<UserDataModel>()

    override fun getSettingsList() {
        listOf(
            AccountSettingModel(
                icon = R.drawable.ic_bookmark_empty,
                title = R.string.account_wishlist_setting,
                action = SettingAction.Wishlist
            ),
            AccountSettingModel(
                icon = R.drawable.ic_favorite_empty,
                title = R.string.account_favorite_setting,
                action = SettingAction.Favorite
            ),
            AccountSettingModel(
                icon = R.drawable.ic_edit,
                title = R.string.account_edit_setting,
                action = SettingAction.Edit
            ),
            AccountSettingModel(
                icon = R.drawable.ic_language,
                title = R.string.language_title,
                action = SettingAction.Language
            ),
            AccountSettingModel(
                icon = R.drawable.ic_logout,
                title = R.string.account_logout_setting,
                action = SettingAction.Exit
            )
        ).also(settingsLiveData::postValue)
    }

    override fun getUserData() {
        userDataLiveData.postValue(FilmsFactory.userData)
    }

}