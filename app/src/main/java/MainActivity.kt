package com.example.unscramble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UnscrambleScreen()
        }
    }
}

@Composable
fun UnscrambleScreen(
    viewModel: GameViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD))
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "UNSCRAMBLE",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "Unscramble the word!",
            color = Color.Black
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // Current word from GameViewModel
        Text(
            text = viewModel.words[viewModel.currentWordIndex],
            fontSize = 40.sp,
            color = Color.Black
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        // Score from GameViewModel
        Text(
            text = "Score: ${viewModel.score}",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
    }
}