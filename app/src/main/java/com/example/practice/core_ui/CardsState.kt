package com.example.practice.core_ui

import androidx.compose.runtime.Immutable
import com.example.practice.data.BankCard

sealed interface CardsState : State {

    object Empty : CardsState

    @Immutable
    data class Data(
        val cards: List<BankCard>
    ) : CardsState
}