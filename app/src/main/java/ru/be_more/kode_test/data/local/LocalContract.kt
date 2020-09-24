package ru.be_more.kode_test.data.local

interface LocalContract {

    interface PhotoRepository{
        /**@return true when success*/
        fun savePhoto(url: String, name: String): Boolean
    }
}