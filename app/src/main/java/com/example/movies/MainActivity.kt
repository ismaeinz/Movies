package com.example.movies


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.movies.app.presnention.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesTheme {

            }
        }
    }
}
//https://youtu.be/38FKk1MlMCk?list=PLy1MhTvkr6qIjjBxt2Q7VtYgAsopGX8ZA&t=618

//https://api.themoviedb.org/3/discover/movie?&api_key=aee2e249581b1ef7ed2cb17f5629ef39