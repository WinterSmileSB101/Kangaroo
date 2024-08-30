package org.smilesb101.kangaroo.movies.ui.screens.movies

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen

@Composable
fun MoviesScreenContent(modifier: Modifier = Modifier) {
    Text("Movies")
}

class MoviesScreen : Screen {
    @Composable
    override fun Content() {
        MoviesScreenContent()
    }

}