package com.example.unscramble

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // =====================================
    // PHASE 6 - GAME DATA
    // =====================================

    val words: List<String> = listOf(
        "CAT",
        "DOG",
        "BOOK"
    )

    var currentWordIndex = 0

    var score = 0

    var userAnswer = ""
}