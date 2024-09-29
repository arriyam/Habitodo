package com.example.habitodo.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.habitodo.model.Goal

class GoalDetailsViewModel : ViewModel() {
    private val _goal = MutableLiveData<Goal>()
    val goal: LiveData<Goal> = _goal

    fun setGoal(selectedGoal: Goal) {
        _goal.value = selectedGoal
    }
}
