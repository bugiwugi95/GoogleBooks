package com.example.booksgoogle.network

import com.example.booksgoogle.model.BooksData
import retrofit2.http.GET

interface ApiBooks {
    /**
     * Mетод для получения данных с url
     */
    @GET("q=search+terms")
    suspend fun getBooks(): MutableList<BooksData>
}