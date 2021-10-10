package com.jefisu.ktortanderapp.features.presentation.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardDetail(
    painter: Painter,
    description: String,
    name: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(230.dp)
            ) {
                Image(
                    painter = painter,
                    contentDescription = name
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = name,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = description,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 30.dp)
        )
    }

}