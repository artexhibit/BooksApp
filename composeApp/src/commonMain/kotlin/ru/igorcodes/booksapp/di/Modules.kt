package ru.igorcodes.booksapp.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.igorcodes.booksapp.book.data.database.DatabaseFactory
import ru.igorcodes.booksapp.book.data.database.FavoriteBookDatabase
import ru.igorcodes.booksapp.book.data.network.KtorRemoteBookDataSource
import ru.igorcodes.booksapp.book.data.network.RemoteBookDataSource
import ru.igorcodes.booksapp.book.data.repository.DefaultBookRepository
import ru.igorcodes.booksapp.book.domain.BookRepository
import ru.igorcodes.booksapp.book.presentation.SelectedBookViewModel
import ru.igorcodes.booksapp.book.presentation.book_details.BookDetailsViewModel
import ru.igorcodes.booksapp.book.presentation.book_list.BookListViewModel
import ru.igorcodes.booksapp.core.data.HttpClientFactory

expect val platformModule: Module

val sharedModule = module {
    single {
        HttpClientFactory.create(get())
    }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
       get<DatabaseFactory>()
           .create()
           .setDriver(BundledSQLiteDriver())
           .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
    viewModelOf(::BookDetailsViewModel)
}