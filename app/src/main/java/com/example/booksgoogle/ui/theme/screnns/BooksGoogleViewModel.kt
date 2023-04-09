package com.example.booksgoogle.ui.theme.screnns

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.booksgoogle.BooksApplication
import com.example.booksgoogle.data.BooksRepository
import com.example.booksgoogle.model.BooksData
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.EOFException

class BooksGoogleViewModel(private val booksRepository: BooksRepository) : ViewModel() {
    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        getBooks()
    }

    fun getBooks() {
        viewModelScope.launch {
            booksUiState = BooksUiState.Loading
            booksUiState = try {
                BooksUiState.Success(booksRepository.getBooks())
            } catch (e: EOFException) {
                BooksUiState.Error
            } catch (e: HttpException) {
                BooksUiState.Error
            }
        }

    }

    /**
     * Фабрика для [ViewModelBooks], которая принимает [BooksRepository] в качестве зависимости
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BooksApplication)
                val booksRepository = application.container.booksRepository
                BooksGoogleViewModel(booksRepository = booksRepository)
            }
        }
    }
}


sealed interface BooksUiState {
    data class Success(val booksData: MutableList<BooksData>) : BooksUiState
    object Loading : BooksUiState
    object Error : BooksUiState

}

