package ru.be_more.kode_test.domain.model

data class RecipeShort(
    val uuid: String,
    val name: String,
    val image: String,
    val lastUpdated: Int,
    val instructions: String,
    val description: String
)