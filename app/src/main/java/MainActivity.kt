package com.example.unscramble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UnscrambleScreen()
        }
    }
}

@Composable
fun UnscrambleScreen() {

    // Phase 2: Remember the user's answer
    var answer by remember {
        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD))
            .padding(24.dp)
            .clickable {
                focusManager.clearFocus()
            },

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        // Title
        Text(
            text = "UNSCRAMBLE",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        // Instruction
        Text(
            text = "Unscramble the word!",
            color = Color.Black
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        // Scrambled word
        Text(
            text = "LPAEP",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // Phase 2: Working TextField
        OutlinedTextField(
            value = answer,

            onValueChange = {
                answer = it
            },

            label = {
                Text("Enter your answer")
            },

            modifier = Modifier.fillMaxWidth(),

            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // Submit button
        // Phase 2: Button does nothing yet
        Button(
            onClick = {
                // Nothing happens
            },

            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "SUBMIT"
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // Score
        Text(
            text = "Score: 0",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
    }
}
