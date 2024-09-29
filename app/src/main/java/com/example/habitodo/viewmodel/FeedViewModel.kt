package com.example.habitodo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.habitodo.model.Goal
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController

class FeedViewModel : ViewModel() {
    // Mock data for the list of goals
    private val _goalList = MutableLiveData<List<Goal>>()
    val goalList: LiveData<List<Goal>> = _goalList
    val clickedGoalTitle = mutableStateOf("")

    private val _showAddGoalDialog= MutableLiveData(false)
    val showAddGoalDialog: LiveData<Boolean> = _showAddGoalDialog

    init {
        // Initialize a list of 10 meaningful goals
        _goalList.value = listOf(
            Goal(
                title = "Find a Job",
                description = "Apply to jobs, prepare for interviews, and secure a position in my field.",
                isCompleted = false
            ),
            Goal(
                title = "Learn a Sport",
                description = "Pick up and practice tennis twice a week to improve my skills.",
                isCompleted = false
            ),
            Goal(
                title = "Improve Swimming",
                description = "Attend weekly swimming lessons and work on building endurance and technique.",
                isCompleted = false
            ),
            Goal(
                title = "Get Better Sleep",
                description = "Establish a consistent sleep schedule and aim for 8 hours of sleep every night.",
                isCompleted = false
            ),
            Goal(
                title = "Read More Books",
                description = "Read at least one book a month to expand knowledge and improve focus.",
                isCompleted = false
            ),
            Goal(
                title = "Save More Money",
                description = "Set aside 15% of my income each month into a savings account for future plans.",
                isCompleted = false
            ),
            Goal(
                title = "Exercise Regularly",
                description = "Work out at least three times a week to maintain a healthy lifestyle.",
                isCompleted = false
            ),
            Goal(
                title = "Eat Healthier",
                description = "Incorporate more fruits and vegetables into my daily meals and cut down on junk food.",
                isCompleted = false
            ),
            Goal(
                title = "Learn a New Language",
                description = "Practice Spanish using language apps for 20 minutes each day to achieve conversational fluency.",
                isCompleted = false
            ),
            Goal(
                title = "Develop a Side Project",
                description = "Create a personal project to build my portfolio and enhance coding skills.",
                isCompleted = false
            )
        )
    }


    fun onGoalClick(goal: Goal, navController: NavHostController) {
        // Navigate to GoalDetailsScreen with the goal title passed as an argument
        navController.navigate("goal_details_screen/${goal.title}")
    }

    fun onAddGoalClicked() {
        Log.d("FeedViewModel", "Add Goal Clicked")
        _showAddGoalDialog.value = true
    }

    fun onAddTaskClicked() {
        Log.d("FeedViewModel", "Add Goal Clicked")
        _showAddGoalDialog.value = true
    }

    fun dismissDialog() {
        _showAddGoalDialog.value = false
    }

    fun addGoal(goalName: String, goalDescription: String) {
        // Add logic here (e.g., adding to a list or repository)
        Log.d("FeedViewModel", "Goal Added: $goalName, Description: $goalDescription")
        _goalList.value = _goalList.value?.plus(
            Goal(
                title = goalName,
                description = goalDescription,
                isCompleted = false,
            )
        )
        dismissDialog()
    }
}
