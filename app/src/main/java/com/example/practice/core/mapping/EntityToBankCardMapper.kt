package com.example.practice.core.mapping

import com.example.practice.core.data.BankCard
import com.example.practice.core.data.BankCardEntity
import javax.inject.Inject

class EntityToBankCardMapper @Inject constructor() {
    operator fun invoke(entity: BankCardEntity): BankCard = with(entity) {
        BankCard(
            cardType = cardType,
            cardName = cardName,
            balance = balance,
            cardNum = cardNum
        )
    }
}