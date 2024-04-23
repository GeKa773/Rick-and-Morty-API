package com.gekaradchenko.app.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
    ) {
        Button(onClick = { viewModel.updateList() }) {
            Text(text = "Update")
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(count = uiState.size) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 16.dp)
                ) {
                    Text(text = "id = ${uiState[it].id}")
                    Text(text = "name = ${uiState[it].name}")
                    Text(text = "gender = ${uiState[it].gender}")
                }
            }

        }
    }

}


@Composable
@Preview(showBackground = true)
private fun CharacterScreenPreview(
    viewModel: CharacterViewModel = hiltViewModel()
) {
    CharacterScreen()
}