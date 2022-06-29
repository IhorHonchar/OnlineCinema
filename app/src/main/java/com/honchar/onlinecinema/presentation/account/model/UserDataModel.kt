package com.honchar.onlinecinema.presentation.account.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDataModel(
    val avatar: String,
    var fullName: String,
    val email: String
): Parcelable
