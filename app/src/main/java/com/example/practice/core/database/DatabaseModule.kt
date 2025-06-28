package com.example.practice.core.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): CardDatabase {
        return Room.databaseBuilder(
            context,
            CardDatabase::class.java,
            "bank-cards-db"
        ).build()
    }

    @Provides
    fun providesBankCardDao(database: CardDatabase): BankCardDao {
        return database.bankCardDao()
    }
}