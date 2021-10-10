package com.jefisu.ktortanderapp.features.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jefisu.ktortanderapp.features.presentation.detail.components.CardDetail

@ExperimentalCoilApi
@Composable
fun DetailScreen(
    id: Int,
    viewModel: DetailViewModel = hiltViewModel()
) {
    viewModel.getMember(id)
    val member = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val painter = rememberImagePainter(data = member.imageUrl)
        CardDetail(
            painter = painter,
            description = member.description,
            name = member.name
        )
//        Image(
//            painter = painter,
//            contentDescription = member.name,
//            modifier = Modifier
//                .size(250.dp)
//                .clip(RoundedCornerShape(15.dp))
//        )
//        Spacer(modifier = Modifier.height(2.dp))
//        Text(
//            text = member.name,
//            fontSize = 35.sp,
//            fontWeight = FontWeight.Bold
//        )
//        Spacer(modifier = Modifier.height(2.dp))
//        Row(modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 20.dp)
//        ) {
//            Text(text = member.description, maxLines = 6)
//        }
    }
}