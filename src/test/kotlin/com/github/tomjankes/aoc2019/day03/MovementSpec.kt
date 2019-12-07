package com.github.tomjankes.aoc2019.day03

import com.github.tomjankes.aoc2019.day03.Direction.*
import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe


class MovementSpec : Spek({
    fun allHaveTheSameXCoordinateAs(point: Point): Matcher<List<Point>> {
        return Matcher.Companion("all have the same X coordinate as $point") { p -> p.all { it.x == point.x } }
    }

    fun allHaveTheDifferentYCoordinateThan(point: Point): Matcher<List<Point>> {
        return Matcher.Companion("all have different Y coordinate than $point") { p -> p.all { it.y != point.y } }
    }

    fun noneOfThePointsEquals(point: Point): Matcher<List<Point>> {
        return Matcher.Companion("none of the points equals") { p -> p.none { it == point } }
    }

    describe("Movement") {
        it("should parse string to distance") {
            assertThat(Movement.fromString("R213").distance, equalTo(213))
            assertThat(Movement.fromString("U1").distance, equalTo(1))
            assertThat(Movement.fromString("L0").distance, equalTo(0))
            assertThat(Movement.fromString("D12312").distance, equalTo(12312))
        }

        it("should parse string to direction") {
            assertThat(Movement.fromString("R213").direction, equalTo(RIGHT))
            assertThat(Movement.fromString("U1").direction, equalTo(UP))
            assertThat(Movement.fromString("L0").direction, equalTo(LEFT))
            assertThat(Movement.fromString("D12312").direction, equalTo(DOWN))
        }

        it("should list all points from starting point to end") {
            val startingPoint = Point(0, 0)

            val points = Movement(UP, 10).pointsFrom(startingPoint)

            assertThat(points, hasSize(equalTo(10)))
            assertThat(points, allHaveTheSameXCoordinateAs(startingPoint))
            assertThat(points, allHaveTheDifferentYCoordinateThan(startingPoint))
            assertThat(points, noneOfThePointsEquals(startingPoint))
        }
    }
})