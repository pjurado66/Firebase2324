package com.pjurado.firebase2324.model

data class Note(
    var id: String = "",
    val userId: String,
    val title: String,
    val description: String
)
