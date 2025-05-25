package ru.igorcodes.booksapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.igorcodes.booksapp.app.App
import ru.igorcodes.booksapp.di.initKoin

fun main() {
    initKoin()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BooksApp",
        ) {
            App()
        }
    }
}