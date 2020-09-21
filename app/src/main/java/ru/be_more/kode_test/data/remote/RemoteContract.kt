package ru.be_more.kode_test.data.remote

import io.reactivex.Single
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.domain.model.RecipeShort


interface RemoteContract {

    interface RecipeRepository {
        fun getRecipe(id: String): Single<Recipe>
        fun getRecipes(): Single<List<RecipeShort>>
        fun release()
    }
}