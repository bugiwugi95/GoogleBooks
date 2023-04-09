package com.example.booksgoogle.data

import com.example.booksgoogle.network.ApiBooks
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Контейнер зависимостей для обьектов
 */
interface AppContainer {
    val booksRepository: BooksRepository
}
/**
 * Реализация контейнера зависимостей
 */
class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://www.googleapis.com/books/v1/volumes?"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()
    /**
     * Создание обьекта дляя вызова api
     */
    private val retrofitService: ApiBooks by lazy {
        retrofit.create(ApiBooks::class.java)
    }
        //DI
    override val booksRepository: BooksRepository
        get() = NetworkBooksRepository(retrofitService)

}