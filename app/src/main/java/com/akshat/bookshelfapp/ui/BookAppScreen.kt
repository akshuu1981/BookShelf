package com.akshat.bookshelfapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.akshat.bookshelfapp.R
import com.akshat.bookshelfapp.ui.screen.BookViewModel
import com.akshat.bookshelfapp.ui.screen.BooksList

@Composable
fun BookAppScreen(viewModel: BookViewModel){
    val books by viewModel.books.collectAsState(initial = emptyList())

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { BookTopBar() },
        ) { innerPadding ->
            BooksList(books = books, modifier = Modifier.padding(innerPadding)
                .fillMaxSize())
    }

    LaunchedEffect(Unit) {
        viewModel.fetchBooks()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookTopBar(){
    TopAppBar(
        title = {
            stringResource(id = R.string.app_name)
        },
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}