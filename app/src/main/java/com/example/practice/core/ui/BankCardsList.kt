package com.example.practice.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practice.core.screens.cards_screen.action.CardsAction
import com.example.practice.core.screens.cards_screen.viewmodel.CardsViewModel
import com.example.practice.core.data.BankCard
import com.example.practice.core.data.CardType

@Composable
fun BankCardsList(
    viewModel: CardsViewModel,
    modifier: Modifier = Modifier
) {
    val cards = List(10) {
        BankCard(
            cardType = CardType.VISA,
            cardName = "Business",
            balance = 46.467,
            cardNum = "3664 7865 3786 3976"
        )
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            AddCardItem(
                onClick = { viewModel.doAction(CardsAction.AddCardClicked) }
            )
        }
        items(cards) { card ->
            CardItem(
                card = card,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}