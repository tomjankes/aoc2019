package com.github.tomjankes.aoc2019.day03

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe


class PointSpec : Spek({
    describe("Point") {

        it("should move by 3 downwards") {
            val startingPoint = Point(0, 0)
            val endPoint = startingPoint.moveBy(Movement(Direction.DOWN, 3))
            assertThat(endPoint, equalTo(Point(0, -3)))
        }

        it("should move by 100 upwards") {
            val startingPoint = Point(0, 0)
            val endPoint = startingPoint.moveBy(Movement(Direction.UP, 100))
            assertThat(endPoint, equalTo(Point(0, 100)))
        }

        it("should move by 3 left") {
            val startingPoint = Point(0, 0)
            val endPoint = startingPoint.moveBy(Movement(Direction.LEFT, 3))
            assertThat(endPoint, equalTo(Point(-3, 0)))
        }

        it("should move by 100 right") {
            val startingPoint = Point(0, 0)
            val endPoint = startingPoint.moveBy(Movement(Direction.RIGHT, 100))
            assertThat(endPoint, equalTo(Point(100, 0)))
        }

        it("should calculate manhattan distance in straight X line") {
            assertThat(Point(10, 0).manhattanDistance(Point(20, 0)), equalTo(10))
        }

        it("should calculate manhattan distance in straight Y line") {
            assertThat(Point(10, 20).manhattanDistance(Point(10, 5)), equalTo(15))
        }

        it("should calculate manhattan distance in curved line") {
            assertThat(Point(1, 1).manhattanDistance(Point(0, 0)), equalTo(2))
            assertThat(Point(1, 2).manhattanDistance(Point(0, 0)), equalTo(3))
        }
    }
})