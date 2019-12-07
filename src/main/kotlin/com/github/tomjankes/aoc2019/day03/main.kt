package com.github.tomjankes.aoc2019.day03

import com.github.tomjankes.aoc2019.day03.Direction.*
import com.github.tomjankes.aoc2019.getFile
import kotlin.math.abs

fun String.parseInput() = this.split(",").map { Movement.fromString(it) }
fun readInputFromResources(): List<String> = "input03.txt".getFile().readLines()

enum class Direction { RIGHT, DOWN, UP, LEFT; }

data class Movement(val direction: Direction, val distance: Int) {
    companion object {
        private fun String.readDistance() = this.substring(1).toInt()
        private fun String.readDirection() = when (this.first()) {
            'L' -> LEFT
            'R' -> RIGHT
            'U' -> UP
            'D' -> DOWN
            else -> throw IllegalArgumentException("$this cannot be parsed to movement")
        }

        fun fromString(string: String): Movement = Movement(string.readDirection(), string.readDistance())
    }

    fun pointsFrom(point: Point): List<Point> {
        return (1..distance).map { currentDistance -> point.moveBy(copy(distance = currentDistance)) }
    }
}

data class Point(val x: Int, val y: Int) {
    fun moveBy(movement: Movement): Point = when (movement.direction) {
        RIGHT -> copy(x = x + movement.distance)
        LEFT -> copy(x = x - movement.distance)
        UP -> copy(y = y + movement.distance)
        DOWN -> copy(y = y - movement.distance)
    }

    fun manhattanDistance(point: Point): Int {
        return abs(x - point.x) + abs(y - point.y)
    }
}

tailrec fun createWire(startingPoint: Point, movementsToRun: List<Movement>, pointsSoFar: List<Point> = listOf()): List<Point> {
    if (movementsToRun.isEmpty()) {
        return pointsSoFar
    }
    val points = pointsSoFar + movementsToRun.first().pointsFrom(startingPoint)
    return createWire(points.last(), movementsToRun.drop(1), points)
}

fun intersections(first: List<Point>, second: List<Point>): Set<Point> {
    return first.toSet().intersect(second)
}

fun runTask01(firstWire: String, secondWire: String): Int? {
    val startingPoint = Point(0, 0)
    val firstWirePoints = createWire(startingPoint, firstWire.parseInput())
    val secondWirePoints = createWire(startingPoint, secondWire.parseInput())
    return intersections(firstWirePoints, secondWirePoints)
        .map { startingPoint.manhattanDistance(it) }
        .min()
}

fun runTask01(): Int? {
    val input = readInputFromResources()
    return runTask01(input[0], input[1])
}

fun combinedStepsToReachIntersection(firstWire: List<Point>, secondWire: List<Point>, intersection: Point) : Int {
    return firstWire.indexOf(intersection) + secondWire.indexOf(intersection) + 2
}

fun runTask02(firstWire: String, secondWire: String): Int? {
    val startingPoint = Point(0, 0)
    val firstWirePoints = createWire(startingPoint, firstWire.parseInput())
    val secondWirePoints = createWire(startingPoint, secondWire.parseInput())
    return intersections(firstWirePoints, secondWirePoints)
        .map { combinedStepsToReachIntersection(firstWirePoints, secondWirePoints, it) }
        .min()
}

fun runTask02(): Int? {
    val input = readInputFromResources()
    return runTask02(input[0], input[1])
}

fun main() {
    println("Smallest distance is ${runTask01()}")
    println("Smallest number of steps is ${runTask02()}")
}