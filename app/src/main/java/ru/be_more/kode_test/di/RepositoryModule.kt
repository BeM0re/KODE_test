package ru.be_more.kode_test.di

import org.koin.dsl.module
import ru.be_more.kode_test.data.local.LocalContract
import ru.be_more.kode_test.data.local.PhotoRepositoryImpl
import ru.be_more.kode_test.data.remote.RemoteContract
import ru.be_more.kode_test.data.remote.repositories.RecipeRepositoryImpl


@JvmField
val repositoryModule = module {
    single<RemoteContract.RecipeRepository> { RecipeRepositoryImpl(get()) }
    single<LocalContract.PhotoRepository> { PhotoRepositoryImpl(get()) }
}