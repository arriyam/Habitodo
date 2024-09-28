package com.example.habitodo.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AddGoalDialog(
    onDismiss: () -> Unit,       // To close the dialog
    onConfirm: (String, String) -> Unit // Pass the goal and description when confirmed
) {
    var goalName by remember { mutableStateOf("") }
    var goalDescription by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier.padding(16.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Add New Goal", style = MaterialTheme.typography.titleLarge)

                // TextField for Goal Name
                TextField(
                    value = goalName,
                    onValueChange = { goalName = it },
                    label = { Text(text = "Goal Name") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1 // Keep it to 1 line
                )

                // Spacer between fields
                Spacer(modifier = Modifier.height(8.dp))

                // TextField for Goal Description with increased height
                TextField(
                    value = goalDescription,
                    onValueChange = { goalDescription = it },
                    label = { Text(text = "Goal Description") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(125.dp), // Set this height to make the description field larger
                    maxLines = 6, // Allow up to 6 lines of input
                    singleLine = false
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Row for Cancel and Enter buttons
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onDismiss) {
                        Text(text = "Cancel")
                    }

                    TextButton(onClick = {
                        if (goalName.isNotEmpty() && goalDescription.isNotEmpty()) {
                            onConfirm(goalName, goalDescription)
                        }
                    }) {
                        Text(text = "Enter")
                    }
                }
            }
        }
    }
}

