package com.example.booksgoogle.model

import com.google.gson.annotations.SerializedName


data class BooksData(

    @SerializedName("kind") var kind: String? = null,
    @SerializedName("totalItems") var totalItems: Int? = null,
    @SerializedName("items") var items: ArrayList<Items> = arrayListOf()

)