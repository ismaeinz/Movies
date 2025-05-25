package com.example.movies.app.data.remote

import com.example.movies.app.data.remote.responed.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("movie/{category}")
    suspend fun getMoviesList(
        @Path("category") category: String,
        @Path("page") page: Int,
        @Path("api_key") apikey: String = API_KEY,

        ): MovieListDto

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = "aee2e249581b1ef7ed2cb17f5629ef39"
    }
}
