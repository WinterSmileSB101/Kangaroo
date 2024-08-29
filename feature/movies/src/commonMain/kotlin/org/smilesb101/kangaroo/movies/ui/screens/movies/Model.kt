package org.smilesb101.kangaroo.movies.ui.screens.movies

import org.smilesb101.kangaroo.domain.entities.Movie

data class MoviesUIState(
    val nowPlayingMovies: List<Movie>,
    val popularMovies: List<Movie>,
    val topRatedMovies: List<Movie>,
    val upComingMovies: List<Movie>
)

sealed class Intent {
    data object RequestMoreUpComingMovies : Intent()

    data object RequestMorePopularMovies : Intent()

    data object RequestMoreTopRatedMovies : Intent()

    data object RequestMoreNowPlayingMovies : Intent()
    data object Setup : Intent()
}