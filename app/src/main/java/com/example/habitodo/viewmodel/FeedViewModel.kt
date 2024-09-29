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
        // Mock a flat list of goals
        _goalList.value = List(10) { goalIndex ->
            Goal(
                title = "Goal $goalIndex",
                description = "Description of goal $goalIndex",
                isCompleted = false
            )
        }
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
