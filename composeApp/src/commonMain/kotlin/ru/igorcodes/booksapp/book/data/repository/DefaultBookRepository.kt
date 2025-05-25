package ru.igorcodes.booksapp.book.data.repository

import ru.igorcodes.booksapp.book.data.mappers.toBook
import ru.igorcodes.booksapp.book.data.network.RemoteBookDataSource
import ru.igorcodes.booksapp.book.domain.Book
import ru.igorcodes.booksapp.book.domain.BookRepository
import ru.igorcodes.booksapp.core.domain.DataError
import ru.igorcodes.booksapp.core.domain.Result
import ru.igorcodes.booksapp.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }
}