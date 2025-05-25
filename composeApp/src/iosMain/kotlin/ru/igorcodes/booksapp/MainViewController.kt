package ru.igorcodes.booksapp

import androidx.compose.ui.window.ComposeUIViewController
import ru.igorcodes.booksapp.app.App
import ru.igorcodes.booksapp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }