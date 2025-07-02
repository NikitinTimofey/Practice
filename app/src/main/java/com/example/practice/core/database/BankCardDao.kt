package com.example.practice.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.practice.core.data.BankCardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BankCardDao {
    @Query("SELECT * FROM bank_cards")
    fun getAllCards(): Flow<List<BankCardEntity>>

    @Insert
    suspend fun insertCard(card: BankCardEntity)

    @Query("DELETE FROM bank_cards WHERE id = :cardId")
    suspend fun deleteCard(cardId: Long)
}