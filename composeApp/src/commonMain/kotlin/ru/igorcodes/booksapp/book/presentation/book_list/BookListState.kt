package ru.igorcodes.booksapp.book.presentation.book_list

import ru.igorcodes.booksapp.book.domain.Book
import ru.igorcodes.booksapp.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)