package com.example.habitodo.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.habitodo.model.Goal
import com.example.habitodo.viewmodel.GoalDetailsViewModel

@Composable
fun GoalDetailsScreen(goal: Goal) {
    Text(text = "Goal: ${goal.title}\nDescription: ${goal.description}")
}
