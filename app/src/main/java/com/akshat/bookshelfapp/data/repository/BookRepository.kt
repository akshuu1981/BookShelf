package com.akshat.bookshelfapp.data.repository

import com.akshat.bookshelfapp.data.model.Book
import com.akshat.bookshelfapp.data.network.BookApiService

interface BookRepository {
    suspend fun getBooks(term:String): List<Book>
}

class BookRepositoryImpl(
    val bookApiService: BookApiService
): BookRepository {

    override suspend fun getBooks(term: String): List<Book>{
        val topLevel = bookApiService.getBooks(term)
        return topLevel.items
    }
}