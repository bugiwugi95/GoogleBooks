package com.example.booksgoogle.repository

import com.example.booksgoogle.data.Book
import com.example.booksgoogle.model.BooksData
import com.example.booksgoogle.model.Items
import com.example.booksgoogle.network.ApiBooks

/**
 * Интерфейс который извлекает список
 */
interface BooksRepository {
    suspend fun getBooks(query: String, maxResults: Int): List<Book>
}

/**
 * Реализация интерфейса [BooksRepository]
 * Сетивой репозиторий который извлекает список
 */
class NetworkBooksRepository(
    private val apiBooks: ApiBooks
) : BooksRepository {
    /**
     * Через [map] достаем нужные нам данные и преобразовываем в [Book]
     */
    override suspend fun getBooks(query: String, maxResults: Int):
            List<Book> = apiBooks.getBooks(query, maxResults).items.map { items: Items ->
        Book(
            title = items.volumeInfo?.title,
            imageLink = items.volumeInfo?.imageLinks?.thumbnail
        )
    }

}


