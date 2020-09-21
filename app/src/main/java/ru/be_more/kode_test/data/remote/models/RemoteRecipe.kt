package ru.be_more.kode_test.data.remote.models

data class RemoteRecipe(
    val uuid: String,
    val name: String,
    val images: List<String>,
    val lastUpdated: Int,
    val description: String,
    val instructions: String,
    val difficulty: Int,
    val similar: List<RemoteRecipeSimilar>
)