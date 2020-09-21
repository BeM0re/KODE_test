package ru.be_more.kode_test.data.remote.model

import ru.be_more.kode_test.domain.model.RecipeSimilar

data class RemoteRecipeSimilar(
    val uuid: String,
    val name: String
){

    fun toModel() =
        RecipeSimilar(
            uuid = uuid,
            name = name
        )
}