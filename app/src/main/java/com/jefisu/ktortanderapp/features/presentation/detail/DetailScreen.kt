package com.jefisu.ktortanderapp.features.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jefisu.ktortanderapp.features.presentation.detail.components.ChatBubble
import com.jefisu.ktortanderapp.features.presentation.util.Screen

@ExperimentalCoilApi
@Composable
fun DetailScreen(
    id: Int,
    viewModel: DetailViewModel = hiltViewModel(),
    navController: NavController
) {
    viewModel.onEvent(DetailEvent.GetMemberById(id))
    val response = viewModel.state.value

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
                    .clickable {
                        navController.navigate(Screen.Home.route)
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = rememberImagePainter(data = response.member?.imageUrl),
                contentDescription = response.member?.name,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if (response.member?.name != null) {
                Text(
                    text = response.member.name,
                    fontSize = 22.sp
                )
            }
        }
        LazyColumn {
            response.member?.let {
                items(it.messages) { message ->
                    ChatBubble(message = message)
                }
            }
        }
    }
}