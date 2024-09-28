package com.example.habitodo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.habitodo.R
import com.example.habitodo.component.GoalList
import com.example.habitodo.viewmodel.FeedViewModel


@Composable
fun FeedScreen(viewModel: FeedViewModel = viewModel()) {
    val goalList by viewModel.goalList.observeAsState(emptyList())
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.habitodo_logo))

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                speed = 0.6f,
                modifier = Modifier.size(50.dp)
            )
        }

        // Use LazyColumn to display the list of goals
        LazyColumn {
            items(goalList) { goal ->
                GoalList(goals = listOf(goal)) { clickedGoal ->
                    viewModel.onGoalClick(clickedGoal)
                }
            }
        }
    }
}



