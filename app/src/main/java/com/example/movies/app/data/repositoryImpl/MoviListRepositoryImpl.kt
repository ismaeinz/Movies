package com.example.movies.app.data.repositoryImpl

import com.example.movies.app.data.local.movie.MovieDatabase
import com.example.movies.app.data.remote.MovieApi
import com.example.movies.app.domain.model.Movie
import com.example.movies.app.domain.repository.MovieListRepository
import com.example.movies.app.mappers.toMovie
import com.example.movies.app.mappers.toMovieEntity
import com.example.movies.app.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviListRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : MovieListRepository {
    override suspend fun getMovieList(
        forcedFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))
//            get Movie FromDb
            val localMovieList =
                movieDatabase.movieDao.getMovieByCategory(category)

            val shouldLoadLocalMovie = localMovieList.isNotEmpty()
                    && !forcedFetchFromRemote
            if (shouldLoadLocalMovie) {
                emit(
                    Resource.Success(
                        data = localMovieList.map { movieEntity ->
                            movieEntity.toMovie(category)
                        }
                    )
                )
                emit(Resource.Loading(false))
                return@flow
            }

            val movieListFromApi = try {
                movieApi.getMoviesList(category, page)
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error "))
                return@flow
            }
//
            val movieEntities =
                movieListFromApi.results.let {
                    it.map { movieDto ->
                        movieDto.toMovieEntity(category)
                    }
                }
            movieDatabase.movieDao.upsertMovieList(movieEntities)
            emit(Resource.Success(
                movieEntities.map { it.toMovie(category) }
            ))
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading(true))
            val movieEntity = movieDatabase.movieDao.getMovieById(id)
            if (movieEntity != null) {
                emit(Resource.Success(movieEntity.toMovie(movieEntity.category)))
                emit(Resource.Loading(false))
                return@flow
            }
            emit(Resource.Error("Error mo such movie"))
            emit(Resource.Loading(false))

        }
    }

}