package com.example.movies.app.data.local.movie

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MovieDao {
    @Upsert
    suspend fun upsertMovieList(movieList: List<MovieEntity>)

    @Query("select * from MovieEntity Where id=:id")
    suspend fun getMovieById(id: Int): MovieEntity

    @Query("select * from MovieEntity Where category=:category")
    suspend fun getMovieByCategory(category: String): List<MovieEntity>
}