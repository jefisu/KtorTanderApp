package com.jefisu.ktortanderapp.features.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatBubble(message: String) {
    Row(
        modifier = Modifier.padding(
            start = 4.dp, top = 8.dp
        )
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = Color(0xFF1F1E1E),
                    shape = RoundedCornerShape(
                        topStart = 4.dp,
                        topEnd = 4.dp,
                        bottomEnd = 4.dp,
                        bottomStart = 0.dp
                    )
                )
        ) {
            Text(
                text = message,
                fontSize = 18.sp,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}