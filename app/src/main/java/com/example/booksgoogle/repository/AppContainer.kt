package com.example.booksgoogle.repository

import com.example.booksgoogle.network.ApiBooks
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
    private val BASE_URL = "https://www.googleapis.com/books/v1/"
//Copy string
    private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    /**
     * Создание обьекта дляя вызова api
     */
    private val retrofitService: ApiBooks by lazy {
        retrofit.create(ApiBooks::class.java)
    }
        //DI
    override val booksRepository: BooksRepository = NetworkBooksRepository(retrofitService)

}