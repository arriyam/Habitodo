package com.example.habitodo.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.habitodo.model.Goal

@Composable
fun GoalList(goals: List<Goal>, onGoalClick: (Goal) -> Unit) {
    Column {
        goals.forEach { goal ->
            GoalListItem(goal = goal, onGoalClick = onGoalClick) // Pass click action
        }
    }
}
