package com.example.practice.core.repository

import com.example.practice.core.data.BankCard
import com.example.practice.core.database.BankCardDao
import com.example.practice.core.mapping.BankCardToEntityMapper
import com.example.practice.core.mapping.EntityToBankCardMapper
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CardsRepositoryImpl @Inject constructor(
    private val bankCardDao: BankCardDao,
    private val toEntityMapper: BankCardToEntityMapper,
    private val toDomainMapper: EntityToBankCardMapper
) : CardsRepository {

    override suspend fun getCardsData(): List<BankCard> {
        return bankCardDao.getAllCards()
            .first()
            .map { toDomainMapper(it)}
    }

    override suspend fun addNewCard(card: BankCard) {
        bankCardDao.insertCard(toEntityMapper(card))
    }
}