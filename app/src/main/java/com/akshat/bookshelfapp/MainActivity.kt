package com.akshat.bookshelfapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.akshat.bookshelfapp.ui.BookAppScreen
import com.akshat.bookshelfapp.ui.screen.BookViewModel
import com.akshat.bookshelfapp.ui.theme.BookshelfAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            BookshelfAppTheme {
                val bookViewModel = hiltViewModel<BookViewModel>()
                BookAppScreen(bookViewModel)
            }
        }
    }
}
