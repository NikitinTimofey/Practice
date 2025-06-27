package com.example.practice.core.repository

import com.example.practice.core.data.BankCard

interface CardsRepository {
    suspend fun getCardsData(): List<BankCard>
    suspend fun addNewCard(card: BankCard): List<BankCard>
}