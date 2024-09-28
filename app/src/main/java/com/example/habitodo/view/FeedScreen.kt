package com.example.habitodo.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.habitodo.viewmodel.FeedViewModel
import com.example.habitodo.component.GoalList
import androidx.compose.foundation.lazy.items

@Composable
fun FeedScreen(viewModel: FeedViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val goalList by viewModel.goalList.observeAsState(emptyList())

    // Use LazyColumn to display the list of goals
    LazyColumn {
        items(goalList) { goal ->
            GoalList(goals = listOf(goal)) { clickedGoal ->
                viewModel.onGoalClick(clickedGoal)
            }
        }
    }
}
