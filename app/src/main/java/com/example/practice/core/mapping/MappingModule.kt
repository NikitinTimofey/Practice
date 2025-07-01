package com.example.practice.core.mapping

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MappingModule {

    @Provides
    fun provideBankCardToEntityMapper(): BankCardToEntityMapper {
        return BankCardToEntityMapper()
    }

    @Provides
    fun provideEntityToBankCardMapper(): EntityToBankCardMapper {
        return EntityToBankCardMapper()
    }
}