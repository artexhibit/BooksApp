package ru.igorcodes.booksapp.book.domain

import ru.igorcodes.booksapp.core.domain.DataError
import ru.igorcodes.booksapp.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}