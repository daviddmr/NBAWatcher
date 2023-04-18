package com.david.nbawatcher.data.network.models

import com.google.gson.annotations.SerializedName

open class NWData

data class NWDataListResponse(
    @SerializedName("data")
    val data: List<NWPlayer>?
)