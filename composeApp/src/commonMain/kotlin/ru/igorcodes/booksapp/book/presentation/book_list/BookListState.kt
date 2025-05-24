package ru.igorcodes.booksapp.book.presentation.book_list

import ru.igorcodes.booksapp.book.domain.Book
import ru.igorcodes.booksapp.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = books,
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)

val books = (1..100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "https://test.com",
        authors = listOf("Igor Volkov"),
        description = "Description $it",
        languages = emptyList(),
        firstPublishYear = null,
        averageRating = 4.67565,
        ratingCount = 5,
        numPages = 100,
        numEditions = 3
    )
}