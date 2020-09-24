package ru.be_more.kode_test.domain.interactors

import ru.be_more.kode_test.data.local.LocalContract
import ru.be_more.kode_test.domain.InteractorContract

class PhotoInteractorImpl(
    private val repo: LocalContract.PhotoRepository
): InteractorContract.PhotoInteractor {

    override fun savePhoto(url: String, name: String) =
        repo.savePhoto(url, name)
}