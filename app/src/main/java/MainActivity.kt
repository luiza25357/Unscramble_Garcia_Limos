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

    // =====================================
    // PHASE 2 - USER ANSWER STATE
    // =====================================

    var userAnswer by remember {
        mutableStateOf("")
    }

    // =====================================
    // PHASE 3 - SCORE STATE
    // =====================================

    var score by remember {
        mutableStateOf(0)
    }

    // =====================================
    // PHASE 3 - CORRECT ANSWER
    // =====================================

    val correctAnswer = "APPLE"

    // Message shown after clicking SUBMIT
    var message by remember {
        mutableStateOf("")
    }

    // Controls the focus of the TextField
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

        // =====================================
        // PHASE 1 - TITLE
        // =====================================

        Text(
            text = "UNSCRAMBLE",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        // =====================================
        // PHASE 1 - INSTRUCTION
        // =====================================

        Text(
            text = "Unscramble the word!",
            color = Color.Black
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        // =====================================
        // PHASE 1 - SCRAMBLED WORD
        // =====================================

        Text(
            text = "LPAEP",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        // =====================================
        // PHASE 2 - WORKING INPUT FIELD
        // =====================================

        OutlinedTextField(
            value = userAnswer,

            onValueChange = {
                userAnswer = it
                message = ""
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

        // =====================================
        // PHASE 3 - SUBMIT BUTTON
        // =====================================

        Button(
            onClick = {

                // Remove keyboard focus
                focusManager.clearFocus()

                // =================================
                // PHASE 3 - IF STATEMENT
                // =================================

                if (userAnswer.trim().equals(
                        correctAnswer,
                        ignoreCase = true
                    )
                ) {

                    // Correct answer
                    score += 1

                    message = "Correct! 🎉"

                } else {

                    // Wrong answer
                    message = "Incorrect. Try again!"

                }
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

        // =====================================
        // PHASE 3 - RESULT MESSAGE
        // =====================================

        Text(
            text = message,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // =====================================
        // PHASE 3 - SCORE
        // =====================================

        Text(
            text = "Score: $score",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
    }
}