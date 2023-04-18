package com.david.nbawatcher.data.network.models

import com.google.gson.annotations.SerializedName

data class NWPlayer(
    @SerializedName("id")
    val id: String?,

    @SerializedName("first_name")
    val firstName: String?,

    @SerializedName("height_feet")
    val heightFeet: String?,

    @SerializedName("height_inches")
    val heightInches: String?,

    @SerializedName("last_name")
    val lastName: String?,

    @SerializedName("position")
    val position: String?,

    @SerializedName("team")
    val team: NWTeam?,

    @SerializedName("weight_pounds")
    val weightPounds: String?
): NWData()