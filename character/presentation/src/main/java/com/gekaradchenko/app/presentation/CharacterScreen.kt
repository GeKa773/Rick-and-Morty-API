package com.gekaradchenko.app.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gekaradchenko.app.android.ui.theme.base_ui.BaseTitleText
import com.gekaradchenko.app.domain.models.response.Character

@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
    ) {
        BaseTitleText(
            text = stringResource(id = R.string.characters),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp)
                .padding(horizontal = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 150.dp),
            modifier = Modifier
                .fillMaxSize()
        ) {

            items(uiState) {
                CharacterCard(
                    character = it,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}


@Composable
private fun CharacterCard(character: Character, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(character.image)
                .crossfade(true)
                .build(),
            contentDescription = "icon",

        )
    }

}


@Composable
@Preview(showBackground = true)
private fun CharacterScreenPreview(
    viewModel: CharacterViewModel = hiltViewModel()
) {
    CharacterScreen()
}