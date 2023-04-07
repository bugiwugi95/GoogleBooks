package com.example.booksgoogle.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class BooksData(
    @SerialName(value = "smallThumbnail")
    val image: String
)
