package com.example.booksgoogle.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.booksgoogle.R
import com.example.booksgoogle.ui.theme.screnns.BooksGoogleViewModel
import com.example.booksgoogle.ui.theme.screnns.HomeScreen


@Composable
fun BooksGoogleApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            val booksGoogleViewModel: BooksGoogleViewModel =
                viewModel(factory = BooksGoogleViewModel.Factory)
            HomeScreen(
                booksUiState = booksGoogleViewModel.booksUiState,
                retryAction = { booksGoogleViewModel.getBooks() }
            )
        }
    }
}