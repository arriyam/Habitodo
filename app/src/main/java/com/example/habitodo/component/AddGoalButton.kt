package com.example.habitodo.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieConstants
import com.example.habitodo.R

@Composable
fun AddGoalButton(onClick: () -> Unit) {
    // Pass the Lottie resource to the generic LottieButton
    LottieButton(lottieRes = R.raw.add_button, 80.dp, 8.dp, 75.dp, LottieConstants.IterateForever, 1.5f,  onClick = onClick)
}