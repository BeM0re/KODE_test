package ru.be_more.kode_test.data.remote.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.be_more.kode_test.data.remote.models.RemoteRecipe
import ru.be_more.kode_test.data.remote.models.RemoteRecipeShort

interface KodeApi {

    @GET("recipes/{uuid}")
    fun getRecipe(@Path("uuid") uuid: String): Single<RemoteRecipe>

    @GET("recipes")
    fun getRecipeList(): Single<List<RemoteRecipeShort>>

}