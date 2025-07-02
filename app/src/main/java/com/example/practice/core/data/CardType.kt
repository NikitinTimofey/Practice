package com.example.practice.core.data

import com.example.practice.R

enum class CardType(val displayName: String, val iconRes: Int) {
    VISA(
        displayName = "Visa Card",
        iconRes = R.drawable.ic_visa
    ),
    MASTERCARD(
        displayName = "Mastercard",
        iconRes = R.drawable.ic_mastercard
    );

    companion object {
        fun fromString(value: String): CardType {
            return entries.firstOrNull() { it.name == value } ?: VISA
        }
    }
}