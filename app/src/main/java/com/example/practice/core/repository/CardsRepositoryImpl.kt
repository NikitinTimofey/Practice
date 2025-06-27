package com.example.practice.core.repository

import com.example.practice.core.data.BankCard
import com.example.practice.core.data.CardType
import javax.inject.Inject

class CardsRepositoryImpl @Inject constructor() : CardsRepository {
    private val _cards = mutableListOf<BankCard>().apply {
        repeat(10) {
            add(
                BankCard(
                    cardType = CardType.VISA,
                    cardName = "Business",
                    balance = 46.46,
                    cardNum = "1234 5678 3123 5432"
                )
            )
        }
    }

    override suspend fun getCardsData(): List<BankCard> {
        return _cards.toList()
    }

    override suspend fun addNewCard(card: BankCard): List<BankCard> {
        _cards.add(card)
        return _cards.toList()
    }
}