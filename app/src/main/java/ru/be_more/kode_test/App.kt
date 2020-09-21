package ru.be_more.kode_test

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.be_more.kode_test.di.interactorModule
import ru.be_more.kode_test.di.networkModule
import ru.be_more.kode_test.di.presentationModule
import ru.be_more.kode_test.di.repositoryModule


open class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(listOf(
//                appModule,
                presentationModule,
                repositoryModule,
//                storageModule,
                interactorModule,
                networkModule)
            )
        }
    }
}