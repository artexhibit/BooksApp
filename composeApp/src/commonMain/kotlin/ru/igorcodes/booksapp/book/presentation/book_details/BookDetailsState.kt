package ru.igorcodes.booksapp.book.presentation.book_details

import ru.igorcodes.booksapp.book.domain.Book

data class BookDetailsState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
