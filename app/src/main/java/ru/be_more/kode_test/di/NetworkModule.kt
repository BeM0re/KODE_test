package ru.be_more.kode_test.di

import org.koin.dsl.module
import ru.be_more.kode_test.consts.KODE_ROOT_URL
import ru.be_more.kode_test.data.remote.api.KodeApi
import ru.be_more.kode_test.data.remote.service.RetrofitFactory

@JvmField
val networkModule = module {
    single { RetrofitFactory() }
    single {
        RetrofitFactory()
            .retrofit(KODE_ROOT_URL)
            .create(KodeApi::class.java)
    }
}