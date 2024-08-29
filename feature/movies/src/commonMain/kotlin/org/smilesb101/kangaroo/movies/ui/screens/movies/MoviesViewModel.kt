package org.smilesb101.kangaroo.movies.ui.screens.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import org.smilesb101.kangaroo.platform.ViewModelMvi

class MoviesViewModel : ViewModel(), ViewModelMvi<Intent> {
    private val _uiState = MutableStateFlow(this.defaultEmptyState())
    val uiState = _uiState.stateIn(viewModelScope, SharingStarted.Eagerly, _uiState.value)

    init {
        execute(Intent.Setup)
    }

    override fun execute(intent: Intent) {
        TODO("Not yet implemented")
    }

    private fun defaultEmptyState() =
        MoviesUIState(
            nowPlayingMovies = emptyList(),
            popularMovies = emptyList(),
            topRatedMovies = emptyList(),
            upComingMovies = emptyList()
        )
}