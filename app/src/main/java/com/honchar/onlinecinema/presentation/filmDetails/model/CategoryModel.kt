package com.honchar.onlinecinema.presentation.filmDetails.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(
    val id: String,
    val name: String
): Parcelable
