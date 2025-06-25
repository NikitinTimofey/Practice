package com.example.practice.core.screens.cards_screen.viewmodel

import com.example.practice.core.common.AbstractViewModel
import com.example.practice.core.common.Action
import com.example.practice.core.data.BankCard
import com.example.practice.core.data.CardType
import com.example.practice.core.screens.cards_screen.action.CardsAction
import com.example.practice.core.screens.cards_screen.state.CardsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor() : AbstractViewModel() {

    private val _state = MutableStateFlow<CardsState>(CardsState.Empty)
    override val state: StateFlow<CardsState> = _state

    init {
        loadCards()
    }

    override fun doAction(action: Action) {
        when (action) {
            is CardsAction.AddCardClicked -> addCard()
            is CardsAction.ToastShown -> clearToast()
        }
    }

    private fun AddCardClicked() {}

    fun addCard() {
        _state.update { currentState ->
            when (currentState) {
                is CardsState.Data -> currentState.copy(toastMessage = "Карта добавлена!")
                is CardsState.Empty -> currentState
            }
        }
    }

    fun clearToast() {
        _state.update { currentState ->
            when (currentState) {
                is CardsState.Data -> currentState.copy(toastMessage = null)
                is CardsState.Empty -> currentState
            }
        }
    }

    private fun loadCards() {
        val cards = List(10) {
            BankCard(
                cardType = CardType.VISA,
                cardName = "Business",
                balance = 46.46,
                cardNum = "1234 5678 9876 5432"
            )
        }
        _state.value = CardsState.Data(cards)
    }
}