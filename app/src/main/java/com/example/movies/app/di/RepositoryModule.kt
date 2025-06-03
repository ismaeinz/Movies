package com.example.movies.app.di

import com.example.movies.app.data.repositoryImpl.MoviListRepositoryImpl
import com.example.movies.app.domain.repository.MovieListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMovieRepository(
        movieListRepositoryImpl: MoviListRepositoryImpl
    ): MovieListRepository
}