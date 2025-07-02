package com.example.practice.core.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank_cards")
data class BankCardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cardType: CardType,
    val cardName: String,
    val balance: Double,
    val cardNum: String
)