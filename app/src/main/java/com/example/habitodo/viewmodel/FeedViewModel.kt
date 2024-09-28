package com.example.habitodo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.habitodo.model.Goal
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    // Mock data for the list of goals
    private val _goalList = MutableLiveData<List<Goal>>()
    val goalList: LiveData<List<Goal>> = _goalList

    // State for clicked goal title
    val clickedGoalTitle = mutableStateOf("")

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

    // Function to handle goal click action
    fun onGoalClick(goal: Goal) {
        // Update clicked goal title or perform any other action
        clickedGoalTitle.value = "Clicked: ${goal.title}"
        // Here you could also trigger navigation or any other logic
    }

    // Define the method to handle the click logic for adding a goal
    fun onAddGoalClicked() {
        // Perform any necessary logic, such as showing a log or interacting with a repository
        Log.d("FeedViewModel", "Add Goal Clicked")

    }
}
