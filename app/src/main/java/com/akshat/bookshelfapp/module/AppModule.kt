package com.akshat.bookshelfapp.module

import com.akshat.bookshelfapp.data.network.BookApiService
import com.akshat.bookshelfapp.data.repository.BookRepository
import com.akshat.bookshelfapp.data.repository.BookRepositoryImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // This module will live as long as the application
object AppModule {

    private val BASE_URL = "https://www.googleapis.com/books/v1/"

    @Provides
    @Singleton
    fun provideBookApiService(): BookApiService {

         val retroJson = Json { ignoreUnknownKeys = true }
         val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(retroJson.asConverterFactory("application/json".toMediaType()))
            .build()
        return retrofit.create(BookApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesBookRepository(bookApiService: BookApiService): BookRepository = BookRepositoryImpl(bookApiService)
}