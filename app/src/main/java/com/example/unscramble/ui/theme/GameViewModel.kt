package com.example.unscramble

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    val words: List<String> = listOf(
        "APPLE",
        "DOG",
        "BOOK"
    )

    var currentWordIndex = 0

    var score = 0

    var userAnswer = ""
}