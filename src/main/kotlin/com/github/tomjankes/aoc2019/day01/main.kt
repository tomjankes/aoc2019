package com.github.tomjankes.aoc2019.day01

import com.github.tomjankes.aoc2019.getFile

fun calculateFuel(mass: Int): Int = mass / 3 - 2

fun calculateFuelFuel(mass: Int): Int {
    var fuel = calculateFuel(mass)
    var additionalFuel = calculateFuel(fuel)
    while (additionalFuel > 0) {
        fuel += additionalFuel
        additionalFuel = calculateFuel(additionalFuel)
    }
    return fuel
}

tailrec fun tailRecursiveCalculateFuel(toCalculate: Int, calculatedSoFar: Int = 0) : Int {
    val calculated = calculateFuel(toCalculate)
    if (calculated <= 0) {
        return calculatedSoFar
    }
    return tailRecursiveCalculateFuel(calculated, calculated + calculatedSoFar)
}

fun runTask01(calculation: (Int) -> Int) : Int {
    return "input01.txt".getFile()
        .readLines()
        .map { it.toInt() }
        .map { calculation(it) }
        .sum()
}

fun main() {
    println(runTask01 { tailRecursiveCalculateFuel(it) })
}
