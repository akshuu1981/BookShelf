package com.akshat.bookshelfapp.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshat.bookshelfapp.data.model.Book
import com.akshat.bookshelfapp.data.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
     private val  repository: BookRepository
): ViewModel() {

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books = _books.asStateFlow()

    init {
        fetchBooks()
    }

    private fun fetchBooks(){
        viewModelScope.launch {
            _books.value = repository.getBooks("jazz+history")
        }
    }
}