package com.example.practice.core.screens.cards_screen.state

import androidx.compose.runtime.Immutable
import com.example.practice.core.common.State
import com.example.practice.core.data.BankCard

sealed interface CardsState : State {

    object Empty : CardsState

    @Immutable
    data class Data(
        val cards: List<BankCard>,
        val toastMessage: String? = null
    ) : CardsState
}