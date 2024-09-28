package com.example.habitodo.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.habitodo.Model.Goal

class FeedViewModel : ViewModel() {
    // Mock data for the carousels of goals
    private val _goalCarousels = MutableLiveData<List<List<Goal>>>()
    val goalCarousels: LiveData<List<List<Goal>>> = _goalCarousels

    init {
        // For now, mock some data for testing
        _goalCarousels.value = List(3) { index ->
            List(5) { goalIndex ->
                Goal(
                    title = "Goal $goalIndex in Carousel $index",
                    description = "Description of goal $goalIndex",
                    isCompleted = false
                )
            }
        }
    }
}
