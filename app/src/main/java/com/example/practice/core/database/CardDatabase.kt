package com.example.practice.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.practice.core.data.BankCardEntity

@Database(
    entities = [BankCardEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CardTypeConverter::class)
abstract class CardDatabase : RoomDatabase() {
    abstract fun bankCardDao(): BankCardDao
}