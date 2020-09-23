package ru.be_more.kode_test.data.remote.model

import ru.be_more.kode_test.domain.model.Recipe

data class RemoteRecipe(
    val uuid: String,
    val name: String,
    val images: List<String>,
    val lastUpdated: Int,
    val description: String?,
    val instructions: String?,
    val difficulty: Int,
    val similar: List<RemoteRecipeSimilar>
){

    fun toModel() =
        Recipe(
            uuid = uuid,
            name = name,
            images = images,
            lastUpdated = lastUpdated,
            description = description?:"",
            instructions = instructions?:"",
            difficulty = difficulty,
            similar = similar.map { it.toModel() }
        )
}