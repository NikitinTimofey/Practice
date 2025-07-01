package com.example.practice.core.database

import androidx.room.TypeConverter
import com.example.practice.core.data.CardType
import com.google.gson.Gson

class CardTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromCardType(cardType: CardType): String {
        return gson.toJson(cardType)
    }

    @TypeConverter
    fun toCardType(json: String): CardType {
        return gson.fromJson(json, CardType::class.java)
    }
}