package com.example.practice.core_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.practice.coreui.CardItem

@Composable
fun CardsScreen(
    modifier: Modifier,
    viewModel: CardsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    when (val currentState = state) {
        is CardsState.Empty -> Unit
        is CardsState.Data -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    AddCardItem(
                        onClick = { viewModel.doAction(CardsAction.AddCardClicked) }
                    )
                }
                items(currentState.cards) { card ->
                    CardItem(card = card)
                }
            }
        }
    }
}