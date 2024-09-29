package com.example.habitodo.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.habitodo.model.Goal
import com.example.habitodo.viewmodel.FeedViewModel
import com.airbnb.lottie.compose.*
import com.example.habitodo.R
import kotlinx.coroutines.delay

@Composable
fun GoalDetailsScreen(goal: Goal, feedViewModel: FeedViewModel) {
    // State for the task dialog
    var showTaskDialog by remember { mutableStateOf(false) }
    var taskName by remember { mutableStateOf("") }
    val tasks = remember { mutableStateListOf<String>() } // List to hold tasks
    var isComplete by remember { mutableStateOf(false) }

    // Handle the Lottie animation completion
    LaunchedEffect(isComplete) {
        if (isComplete) {
            delay(2000) // Adjust the delay time as needed (e.g., 2000 milliseconds)
            isComplete = false // Hide the animation after the delay
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Display goal title and description
        Text(text = "Goal: ${goal.title}", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Description: ${goal.description}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Tasks List
        Text(text = "Tasks", style = MaterialTheme.typography.bodyMedium)
        LazyColumn {
            items(tasks) { task ->
                Text(
                    text = task,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            // Show completion dialog
                            isComplete = true
                        }
                )
            }
        }

        // Floating action button to add a task
        FloatingActionButton(
            onClick = { showTaskDialog = true },
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Task")
        }
    }

    // Task Dialog
    if (showTaskDialog) {
        AlertDialog(
            onDismissRequest = { showTaskDialog = false },
            title = { Text("Add Task") },
            text = {
                Column {
                    TextField(
                        value = taskName,
                        onValueChange = { taskName = it },
                        label = { Text("Task Name") }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (taskName.isNotBlank()) {
                            tasks.add(taskName) // Add task to the list
                            taskName = "" // Clear the input field
                        }
                        showTaskDialog = false
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(onClick = { showTaskDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Center the Lottie Animation for task completion
    if (isComplete) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center // Center the animation
        ) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.checkmark))

            LottieAnimation(
                composition = composition,
                iterations = 1,
                speed = 0.6f,
                modifier = Modifier.size(150.dp)
            )
        }
    }
}

