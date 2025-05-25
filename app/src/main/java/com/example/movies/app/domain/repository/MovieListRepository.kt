package com.example.movies.app.domain.repository

import com.example.movies.app.domain.model.Movie
import com.example.movies.app.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    //    to getMovieList
    suspend fun getMovieList(
        forcedFetchFromRemote: Boolean, category: String, page: Int
    ): Flow<Resource<List<Movie>>>

    //    to getOneMovie
    suspend fun getMovie(
        id: Int
    ): Flow<Resource<Movie>>

}