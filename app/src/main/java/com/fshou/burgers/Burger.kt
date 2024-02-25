package com.fshou.burgers

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Burger (
    val name: String,
    val description: String,
    val price: String,
    val image: String,
    val country: String,
    val rate: String,
    val about: String,
) : Parcelable