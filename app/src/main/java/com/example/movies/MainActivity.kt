package com.example.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.movies.app.presnention.theme.MoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesTheme {

//https://api.themoviedb.org/3/discover/movie?&api_key=aee2e249581b1ef7ed2cb17f5629ef39
            }
        }
    }
}

//https://api.themoviedb.org/3/discover/movie?&api_key=aee2e249581b1ef7ed2cb17f5629ef39
//https://youtu.be/z3upO8AFLO4?list=PLy1MhTvkr6qIjjBxt2Q7VtYgAsopGX8ZA&t=2928