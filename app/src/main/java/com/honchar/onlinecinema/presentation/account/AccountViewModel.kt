package com.honchar.onlinecinema.presentation.account

import com.honchar.onlinecinema.core.base.presentation.BaseViewModel

abstract class IAccountViewModel: BaseViewModel(){

    abstract fun getUserData()
    abstract fun updateUserData()
}

class AccountViewModel: IAccountViewModel() {

    override fun getUserData() {
        TODO("Not yet implemented")
    }

    override fun updateUserData() {
        TODO("Not yet implemented")
    }


}