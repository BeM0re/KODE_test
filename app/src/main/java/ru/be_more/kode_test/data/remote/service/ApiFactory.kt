package ru.be_more.kode_test.data.remote.service

import ru.be_more.kode_test.consts.KODE_ROOT_URL
import ru.be_more.kode_test.data.remote.api.KodeApi


class ApiFactory(
    retrofitFactory: RetrofitFactory
) {
    val kodeApi : KodeApi = retrofitFactory.retrofit(KODE_ROOT_URL)
        .create(KodeApi::class.java)
}