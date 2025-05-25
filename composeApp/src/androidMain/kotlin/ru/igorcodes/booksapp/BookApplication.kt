package ru.igorcodes.booksapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import ru.igorcodes.booksapp.di.initKoin

class BookApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookApplication)
        }
    }
}