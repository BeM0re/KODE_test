package ru.be_more.kode_test.data.remote.repositories

import io.reactivex.Single
import ru.be_more.kode_test.data.remote.RemoteContract
import ru.be_more.kode_test.data.remote.api.KodeApi
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.domain.model.RecipeShort
import ru.be_more.kode_test.extentions.disposables
import ru.be_more.kode_test.extentions.processSingle

class RecipeRepositoryImpl(
    private val api: KodeApi
): RemoteContract.RecipeRepository{

    override fun getRecipe(id: String): Single<Recipe> =
        api.getRecipe(id)
            .map { it.toModel() }
            .processSingle()

    override fun getRecipes(): Single<List<RecipeShort>> =
        api.getRecipeList()
            .map {
                it.recipes
            }
            .map { recipes ->
                recipes.map { it.toModel() }
            }
            .processSingle()

    override fun release() {
        disposables.forEach { it.dispose() }
        disposables.clear()
    }

}