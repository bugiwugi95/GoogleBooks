package com.example.booksgoogle.data

import com.example.booksgoogle.model.BooksData
import com.example.booksgoogle.network.ApiBooks

/**
 * Интерфейс который извлекает список
 */
interface BooksRepository {
    suspend fun getBooks(): MutableList<BooksData>
}
/**
 * Реализация интерфейса [BooksRepository]
 * Сетивой репозиторий который извлекает список
 */
class NetworkBooksRepository(
    private val apiBooks: ApiBooks
) : BooksRepository {
    override suspend fun getBooks(): MutableList<BooksData> {
        return apiBooks.getBooks()
    }

}