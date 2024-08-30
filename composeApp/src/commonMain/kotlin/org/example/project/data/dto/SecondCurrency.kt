package org.example.project.data.dto

import kotlinx.serialization.Serializable

@Serializable

data class SecondCurrency(
    val symbol: String? = "",
    val name: String? = "",
    val id: Int? = 0,
    val nameFa: String? = ""
)