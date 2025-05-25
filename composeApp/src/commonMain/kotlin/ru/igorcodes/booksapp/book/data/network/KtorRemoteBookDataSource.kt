package ru.igorcodes.booksapp.book.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ru.igorcodes.booksapp.book.data.dto.SearchedResponseDto
import ru.igorcodes.booksapp.core.data.safeCall
import ru.igorcodes.booksapp.core.domain.DataError
import ru.igorcodes.booksapp.core.domain.Result

private const val BASE_URL = "https://openlibrary.org"

class KtorRemoteBookDataSource(
    private val httpClient: HttpClient,
) : RemoteBookDataSource {
    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?,
    ): Result<SearchedResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter(
                    "fields",
                    "key, title, language, cover_i, author_key, author_name, cover_edition_key, first_publish_year, ratings_average, ratings_count, number_of_pages_median, edition_count"
                )
            }
        }
    }
}