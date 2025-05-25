package ru.igorcodes.booksapp.book.data.network

import ru.igorcodes.booksapp.book.data.dto.SearchedResponseDto
import ru.igorcodes.booksapp.core.domain.DataError
import ru.igorcodes.booksapp.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null,
    ): Result<SearchedResponseDto, DataError.Remote>
}