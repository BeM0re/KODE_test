package ru.be_more.kode_test.di

import org.koin.dsl.module
import ru.be_more.kode_test.presentation.ViewModelContract
import ru.be_more.kode_test.presentation.details.DetailViewModelImpl
import ru.be_more.kode_test.presentation.recipeList.RecipeListViewModelImpl


@JvmField
val presentationModule = module {
    single<ViewModelContract.RecipeListViewModel> { RecipeListViewModelImpl(get()) }
    single<ViewModelContract.DetailViewModel> { DetailViewModelImpl(get()) }
}