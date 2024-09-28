package com.example.habitodo.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habitodo.Model.Goal

@Composable
fun GoalCarousel(goals: List<Goal>) {
    LazyRow {
        items(goals.size) { index ->
            val goal = goals[index]
            GoalItem(goal = goal)
        }
    }
}

@Composable
fun GoalItem(goal: Goal) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(200.dp),
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


