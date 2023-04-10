package com.example.booksgoogle

import android.app.Application
import com.example.booksgoogle.repository.AppContainer
import com.example.booksgoogle.repository.DefaultAppContainer

/**
 * Экземпляр AppContainer, используемый остальными классами для получения зависимостей
 */
class BooksApplication : Application() {
     lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}