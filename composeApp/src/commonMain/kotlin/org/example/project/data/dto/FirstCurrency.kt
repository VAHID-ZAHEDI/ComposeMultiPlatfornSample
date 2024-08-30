package org.example.project.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class FirstCurrency(
    val symbol: String? = "",
    val name: String? = "",
    val id: Int? = 0,
    val nameFa: String? = ""
)