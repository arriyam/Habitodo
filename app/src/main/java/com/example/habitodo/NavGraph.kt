package com.example.habitodo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habitodo.View.FeedScreen
import com.example.habitodo.View.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "feed_screen") {
        composable("home_screen") {
            HomeScreen()
        }
        composable("feed_screen") {
            FeedScreen()
        }
    }
}
