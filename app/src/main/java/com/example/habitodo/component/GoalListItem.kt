package com.example.habitodo.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habitodo.model.Goal

@Composable
fun GoalListItem(goal: Goal, onGoalClick: (Goal) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth() // Take full width for vertical list
            .clickable(onClick = { onGoalClick(goal) }), // Add click listener
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = goal.title, style = MaterialTheme.typography.headlineMedium)
            Text(text = goal.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
