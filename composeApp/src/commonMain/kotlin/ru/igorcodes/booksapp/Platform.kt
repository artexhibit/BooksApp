package ru.igorcodes.booksapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform