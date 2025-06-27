package com.example.practice.core.screens.cards_screen.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.practice.core.ui.AddCardItem
import com.example.practice.core.screens.cards_screen.action.CardsAction
import com.example.practice.core.screens.cards_screen.state.CardsState
import com.example.practice.core.screens.cards_screen.viewmodel.CardsViewModel
import com.example.practice.core.ui.CardItem

@Composable
fun CardsScreen(
    modifier: Modifier,
    viewModel: CardsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(state) {
        when (val current = state) {
            is CardsState.Data -> {
                current.toastMessage?.let { message ->
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                    viewModel.doAction(CardsAction.ToastShown)
                }
            }
            else -> Unit
        }
    }

    when (state) {
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
                items((state as CardsState.Data).cards) { card ->
                    CardItem(card = card)
                }
            }
        }
    }
}