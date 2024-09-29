package com.example.habitodo.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.habitodo.model.Goal
import com.example.habitodo.viewmodel.FeedViewModel

@Composable
fun GoalDetailsScreen(goal: Goal, feedViewModel: FeedViewModel) {
    Text(text = "Goal: ${goal.title}\nDescription: ${goal.description}")
}
