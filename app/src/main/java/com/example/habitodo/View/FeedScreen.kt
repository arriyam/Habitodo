package com.example.habitodo.View

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.habitodo.ViewModel.FeedViewModel
import com.example.habitodo.component.GoalCarousel

@Composable
fun FeedScreen(viewModel: FeedViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val goalCarousels by viewModel.goalCarousels.observeAsState(emptyList())

    LazyColumn {
        items(goalCarousels) { goals ->
            GoalCarousel(goals = goals)
        }
    }
}
