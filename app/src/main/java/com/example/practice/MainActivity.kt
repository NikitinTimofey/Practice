package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.practice.coreui.CardItem
import com.example.practice.data.BankCard
import com.example.practice.data.CardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CardItem(
                        modifier = Modifier.padding(innerPadding),
                        card = BankCard(
                            cardType = CardType.VISA,
                            cardName = "Business",
                            balance = 46.467,
                            cardNum = "3664 7865 3786 3976"
                        )
                    )
                }
            }
        }
    }
}