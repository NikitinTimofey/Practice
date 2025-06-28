package com.example.practice.core.database

import androidx.room.TypeConverter
import com.example.practice.core.data.CardType

class CardTypeConverter {
    @TypeConverter
    fun fromCardType(cardType: CardType): String = cardType.name

    @TypeConverter
    fun toCardType(value: String): CardType = CardType.valueOf(value)
}