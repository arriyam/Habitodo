package com.example.habitodo.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.LottieConstants
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment

@Composable
fun LottieButton(
    lottieRes: Int,
    onClick: () -> Unit
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(lottieRes)) // replace with your Lottie animation resource

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd // Align to the bottom end of the box
    ) {
        // Use Box to make the Lottie animation clickable without feedback
        Box(
            modifier = Modifier
                .size(80.dp) // Adjust size for your button
                .clickable(
                    onClick = onClick, // Handle the click
                    indication = null, // Disable the click feedback
                    interactionSource = remember { MutableInteractionSource() } // Required when indication is null
                )
                .padding(8.dp) // Optional: add some padding around the Lottie animation
        ) {
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.size(75.dp) // Adjust the size of the Lottie animation
            )
        }
    }
}
