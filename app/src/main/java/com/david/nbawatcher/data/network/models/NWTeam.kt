package com.david.nbawatcher.data.network.models

import com.google.gson.annotations.SerializedName

class NWTeam(
    @SerializedName("id")
    val id: String?,

    @SerializedName("abbreviation")
    val abbreviation: String?,

    @SerializedName("city")
    val city: String?,

    @SerializedName("conference")
    val conference: String?,

    @SerializedName("division")
    val division: String?,

    @SerializedName("full_name")
    val fullName: String?,

    @SerializedName("name")
    val name: String?
)