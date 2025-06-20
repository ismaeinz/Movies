package com.example.movies.app.details.presention

import com.example.movies.app.domain.model.Movie

data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null,
)