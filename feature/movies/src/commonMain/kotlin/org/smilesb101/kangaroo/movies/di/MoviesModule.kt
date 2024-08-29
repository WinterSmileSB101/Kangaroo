package org.smilesb101.kangaroo.movies.di

import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel
import org.smilesb101.kangaroo.movies.ui.screens.movies.MoviesViewModel

val featureMoviesModule = module {
    viewModel {
        MoviesViewModel()
    }
}