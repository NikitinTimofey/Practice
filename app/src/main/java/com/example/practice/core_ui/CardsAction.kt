package com.example.practice.core_ui

sealed interface CardsAction : Action {
    object AddCardClicked : CardsAction
}