package com.github.tomjankes.aoc2019.day04

fun isValidPassword(number: Int) : Boolean {
    var previousCharacter : Char? = null
    val counts = mutableListOf<Int>()
    var currentCount = 1

    for (character in number.toString()) {
        if (previousCharacter != null && character < previousCharacter) {
            return false
        }
        currentCount = when {
            previousCharacter == null -> 1
            previousCharacter != character -> {
                counts.add(currentCount)
                1
            }
            else -> currentCount + 1
        }
        previousCharacter = character
    }
    counts.add(currentCount)
    return counts.contains(2)
}

fun findNumberOfPossiblePasswordsInRange(from: Int, to: Int) : Int {
    return (from..to).filter { isValidPassword(it) }.count()
}

fun main() {
    println("${findNumberOfPossiblePasswordsInRange(136818, 685979)}")
}