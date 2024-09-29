package com.example.habitodo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.habitodo.view.FeedScreen
import com.example.habitodo.view.GoalDetailsScreen
import com.example.habitodo.viewmodel.FeedViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    feedViewModel: FeedViewModel // Pass your FeedViewModel
) {
    NavHost(navController = navController, startDestination = "feed_screen") {
        // Feed Screen
        composable("feed_screen") {
            FeedScreen(navController = navController, feedViewModel = feedViewModel)
        }

        // Goal Details Screen with title as argument
        composable(
            "goal_details_screen/{goalTitle}",
            arguments = listOf(navArgument("goalTitle") { type = androidx.navigation.NavType.StringType })
        ) { backStackEntry ->
            val goalTitle = backStackEntry.arguments?.getString("goalTitle")
            val goal = feedViewModel.goalList.value?.find { it.title == goalTitle } // Retrieve Goal by title

            goal?.let {
                GoalDetailsScreen(goal = it) // Pass the Goal object to the details screen
            }
        }
    }
}