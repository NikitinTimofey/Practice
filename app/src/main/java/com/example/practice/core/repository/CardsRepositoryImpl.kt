package com.example.practice.core.repository

import com.example.practice.core.data.BankCard
import com.example.practice.core.data.BankCardEntity
import com.example.practice.core.database.BankCardDao
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CardsRepositoryImpl @Inject constructor(
    private val bankCardDao: BankCardDao
) : CardsRepository {

    override suspend fun getCardsData(): List<BankCard> {
        return bankCardDao.getAllCards()
            .first()
            .map { it.toBankCard() }
    }

    override suspend fun addNewCard(card: BankCard): List<BankCard> {
        bankCardDao.insertCard(card.toBankCardEntity())
        return getCardsData()
    }

    private fun BankCard.toBankCardEntity() = BankCardEntity(
        cardType = cardType,
        cardName = cardName,
        balance = balance,
        cardNum = cardNum
    )

    private fun BankCardEntity.toBankCard() = BankCard(
        cardType = cardType,
        cardName = cardName,
        balance = balance,
        cardNum = cardNum
    )
}