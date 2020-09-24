package ru.be_more.kode_test.domain.interactors

import io.reactivex.Single
import ru.be_more.kode_test.data.remote.RemoteContract
import ru.be_more.kode_test.domain.InteractorContract
import ru.be_more.kode_test.domain.model.Recipe
import ru.be_more.kode_test.domain.model.RecipeShort

class RecipeInteractorImpl(
    private val repo: RemoteContract.RecipeRepository
): InteractorContract.RecipeInteractor {

    override fun getRecipe(id: String): Single<Recipe> =
        repo.getRecipe(id)

    override fun getRecipes(): Single<List<RecipeShort>> =
        repo.getRecipes()

    override fun release() =
        repo.release()
}