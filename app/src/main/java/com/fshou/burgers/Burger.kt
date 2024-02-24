package com.fshou.burgers

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Burger (
    val name: String,
    val description: String,
    val price: Double,
    val rate: Int,
    val about: String
) : Parcelable