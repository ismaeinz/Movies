package com.example.movies.app.core.presention

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movies.app.presnention.state.MovieListState
import com.example.movies.app.presnention.views.MovieListUiEvent
import com.example.movies.app.util.Category

@Composable
fun UpcomingMovieScreen(
    movieListState: MovieListState,
    navController: NavHostController,
    onEvent: (MovieListUiEvent) -> Unit,
) {

    if (movieListState.upcomingMovieList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
        ) {
            items(movieListState.upcomingMovieList.size) { index ->
                MovieItem(
                    movie = movieListState.upcomingMovieList[index],
                    navHostController = navController
                )
                Spacer(modifier = Modifier.size(16.dp))
                if (index >= movieListState.upcomingMovieList.size - 1 && movieListState.isLoading) {
                    onEvent(MovieListUiEvent.Paginate(Category.UPCOMING))
                }
            }
        }

    }
}

