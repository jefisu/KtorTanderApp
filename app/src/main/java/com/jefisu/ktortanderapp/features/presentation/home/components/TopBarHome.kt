package com.jefisu.ktortanderapp.features.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBarHome(
    onUpdateList: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                top = 10.dp,
                start = 20.dp,
                end = 5.dp
            )
    ) {
        Text(text = "Inbox", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Today",
                fontSize = 19.sp
            )
            IconButton(
                onClick = { onUpdateList() }
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Refresh list",
                    modifier = Modifier.size(27.dp)
                )
            }
        }
    }
}