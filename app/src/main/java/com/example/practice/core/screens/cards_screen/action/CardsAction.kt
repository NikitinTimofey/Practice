package com.example.practice.core.screens.cards_screen.action

import com.example.practice.core.common.Action

sealed interface CardsAction : Action {
    object AddCardClicked : CardsAction
    object ToastShown : CardsAction
}