package com.david.nbawatcher.domain.models

data class Player(
    val id: String?,
    val firstName: String?,
    val heightFeet: String?,
    val heightInches: String?,
    val lastName: String?,
    val position: String?,
    val team: Team?,
    val weightPounds: String?
)