package ru.igorcodes.booksapp.book.presentation.book_details

import ru.igorcodes.booksapp.book.domain.Book

sealed interface BookDetailsAction {
    data object OnBackScreen: BookDetailsAction
    data object OnFavoriteClick: BookDetailsAction
    data class OnSelectedBookChange(val book: Book): BookDetailsAction
}