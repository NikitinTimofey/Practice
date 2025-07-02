package com.example.practice.core.screens.cards_screen.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.practice.core.common.AbstractViewModel
import com.example.practice.core.common.Action
import com.example.practice.core.data.BankCard
import com.example.practice.core.data.CardType
import com.example.practice.core.repository.CardsRepository
import com.example.practice.core.screens.cards_screen.action.CardsAction
import com.example.practice.core.screens.cards_screen.state.CardsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val repository: CardsRepository
) : AbstractViewModel() {

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

    fun addCard() {
        viewModelScope.launch {
            val newCard = BankCard(
                cardType = CardType.MASTERCARD,
                cardName = "New Card",
                balance = 100.0,
                cardNum = "9999 8888 7777 6666"
            )
            repository.addNewCard(newCard)
            loadCards()
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
        viewModelScope.launch {
            val cards = repository.getCardsData()
            _state.value = CardsState.Data(cards)
        }
    }
}