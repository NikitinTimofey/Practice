package com.example.practice.coreui

import com.example.practice.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.data.BankCard
import com.example.practice.data.CardType

@Composable
fun CardItem(
    card: BankCard,
    modifier: Modifier = Modifier
) {
    val image = when (card.cardType) {
        CardType.VISA -> painterResource(R.drawable.ic_visa)
        CardType.MASTERCARD -> painterResource(R.drawable.ic_mastercard)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
            .height(200.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Magenta),
        shape = RoundedCornerShape(35.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(60.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = card.cardNum,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardItemPreview() {
    MaterialTheme {
        CardItem(
            card = BankCard(
                cardType = CardType.VISA,
                cardName = "Business",
                balance = 46.467,
                cardNum = "3664 7865 3786 3976"
            )
        )
    }
}