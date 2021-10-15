package com.jefisu.ktortanderapp.features.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jefisu.ktortanderapp.R
import com.jefisu.ktortanderapp.features.domain.model.Member
import com.jefisu.ktortanderapp.features.presentation.util.Screen

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun CardHome(
    member: Member,
    navController: NavController
) {
    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        onClick = {
            member.id?.let { navController.navigate(Screen.Detail.withArgs(it)) }
        },
        modifier = Modifier
            .padding(start = 15.dp, top = 10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val painter = rememberImagePainter(
                    data = member.imageUrl,
                    builder = {
                        placeholder(R.drawable.ic_loading_image)
                    }
                )
                Image(
                    painter = painter,
                    contentDescription = member.imageUrl,
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .clip(CircleShape)
                        .size(48.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 14.dp)
                ) {
                    Text(text = member.name, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(text = member.description, maxLines = 1)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 56.dp)
                    .height(2.dp),
                color = Color.LightGray
            )
        }
    }
}