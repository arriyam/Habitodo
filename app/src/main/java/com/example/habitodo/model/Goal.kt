package com.example.habitodo.model

class Goal(
    val title: String,
    val description: String,
    var isCompleted: Boolean = false, // Overall goal completion
    private var tasks: MutableList<Pair<Task, Boolean>> = mutableListOf() // Mutable list of Task and its completion status
) {

    // Add a task to the goal
    fun addTask(task: Task) {
        tasks.add(task to false) // Add the task with default completion status of false
    }

    // Remove a task from the goal
    fun removeTask(task: Task) {
        tasks.removeIf { it.first == task } // Remove task matching the description
    }

    // Mark a task as completed
    fun markTaskCompleted(task: Task) {
        tasks = tasks.map {
            if (it.first == task) it.first to true else it
        }.toMutableList()
        // Update overall goal completion status if all tasks are completed
        checkIfGoalCompleted()
    }

    // Mark a task as not completed
    fun markTaskNotCompleted(task: Task) {
        tasks = tasks.map {
            if (it.first == task) it.first to false else it
        }.toMutableList()
        // Update overall goal completion status
        checkIfGoalCompleted()
    }

    // Check if all tasks are completed and update goal completion status
    private fun checkIfGoalCompleted() {
        isCompleted = tasks.all { it.second } // Set to true if all tasks are marked as completed
    }
}
