package com.honchar.onlinecinema.presentation.filmDetails.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActorModel(
    val id: String,
    val name: String,
    val photo: String
): Parcelable
