package com.jefisu.ktortanderapp.features.presentation.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jefisu.ktortanderapp.features.presentation.detail.components.CardDetail
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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val painter = rememberImagePainter(data = response.member?.imageUrl)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.navigate(Screen.Home.route)
                    }
            )
        }
        response.member?.let {
            CardDetail(
                painter = painter,
                description = it.description,
                name = it.name
            )
        }
    }
}