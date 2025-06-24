package com.example.practice.core.data

data class BankCard(
    val cardType: CardType,
    val cardName: String,
    val balance: Double,
    val cardNum: String
)