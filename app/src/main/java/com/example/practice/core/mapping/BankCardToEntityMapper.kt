package com.example.practice.core.mapping

import com.example.practice.core.data.BankCard
import com.example.practice.core.data.BankCardEntity
import javax.inject.Inject

class BankCardToEntityMapper @Inject constructor() {
    operator fun invoke(bankCard: BankCard): BankCardEntity = with(bankCard) {
        BankCardEntity(
            cardType = cardType,
            cardName = cardName,
            balance = balance,
            cardNum = cardNum
        )
    }
}