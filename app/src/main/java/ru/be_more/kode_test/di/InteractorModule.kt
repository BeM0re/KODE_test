package ru.be_more.kode_test.di

import org.koin.dsl.module
import ru.be_more.kode_test.domain.InteractorContract
import ru.be_more.kode_test.domain.interactors.PhotoInteractorImpl
import ru.be_more.kode_test.domain.interactors.RecipeInteractorImpl

@JvmField
val interactorModule = module {
    single<InteractorContract.RecipeInteractor> { RecipeInteractorImpl(get()) }
    single<InteractorContract.PhotoInteractor> { PhotoInteractorImpl(get()) }
}