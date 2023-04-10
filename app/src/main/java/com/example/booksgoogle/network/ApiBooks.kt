package com.example.booksgoogle.network

import com.example.booksgoogle.model.BooksData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiBooks {
    /**
     * Mетод для получения данных с url
     */
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") searchQuery: String,//хранит текст поискового запроса
        @Query("maxResults") maxResults: Int//размер список книг в ответе сервера
    ): BooksData
}