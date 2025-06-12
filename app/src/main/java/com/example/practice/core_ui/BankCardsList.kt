package com.example.practice.coreui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.data.BankCard
import com.example.practice.data.CardType

@Composable
fun BankCardsList(
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
        items(cards) { card ->
            CardItem(
                card = card,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BankCardsListPreview() {
    MaterialTheme {
        BankCardsList()
    }
}