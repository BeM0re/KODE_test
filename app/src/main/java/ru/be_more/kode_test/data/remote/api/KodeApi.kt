package ru.be_more.kode_test.data.remote.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.be_more.kode_test.data.remote.model.RecipeObject
import ru.be_more.kode_test.data.remote.model.RemoteRecipes

interface KodeApi {

    @GET("recipes/{uuid}")
    fun getRecipe(@Path("uuid") uuid: String): Single<RecipeObject>

    @GET("recipes")
    fun getRecipeList(): Single<RemoteRecipes>

}