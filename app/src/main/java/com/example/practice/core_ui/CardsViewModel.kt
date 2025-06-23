package com.example.practice.core_ui

import android.app.Application
import android.widget.Toast
import com.example.practice.data.BankCard
import com.example.practice.data.CardType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject constructor(
    private val application: Application
) : AbstractViewModel() {

    private val _state = MutableStateFlow<CardsState>(CardsState.Empty)
    override val state: StateFlow<CardsState> = _state

    override fun doAction(action: Action) {
        when (action) {
            is CardsAction.AddCardClicked -> showAddCardToast()
        }
    }

    private fun AddCardClicked() {}

    private fun showAddCardToast() {
        Toast.makeText(application, "Добавление карты", Toast.LENGTH_SHORT).show()
    }

    init {
        loadCards()
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