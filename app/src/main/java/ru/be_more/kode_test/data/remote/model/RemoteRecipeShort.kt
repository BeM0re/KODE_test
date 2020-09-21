package ru.be_more.kode_test.data.remote.model

import ru.be_more.kode_test.domain.model.RecipeShort

data class RemoteRecipeShort(
    val uuid: String,
    val name: String,
    val images: List<String>,
    val lastUpdated: Int,
    val description: String,
    val instructions: String,
    val difficulty: Int
){

    fun toModel() =
        RecipeShort(
            uuid = uuid,
            name = name,
            image = images[0],
            lastUpdated = lastUpdated,
            description = description,
            instructions = instructions
        )
}