package com.jefisu.ktortanderapp.features.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.jefisu.ktortanderapp.features.presentation.home.components.CardHome
import com.jefisu.ktortanderapp.features.presentation.home.components.TopBarHome

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val response = viewModel.state.value
    Column(modifier = Modifier.fillMaxSize()) {
        TopBarHome {
            viewModel.onEvent(HomeEvent.GetAllMembers)
        }
        if (response.members.isNotEmpty()) {
            LazyColumn {
                items(response.members) { member ->
                    CardHome(member, navController)
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (response.isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}