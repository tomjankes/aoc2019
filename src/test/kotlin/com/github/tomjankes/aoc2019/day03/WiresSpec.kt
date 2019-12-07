package com.github.tomjankes.aoc2019.day03

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe


class WiresSpec : Spek({

    describe("wires") {
        it("should pass first example from AoC") {
            val firstWire = "R8,U5,L5,D3"
            val secondWire = "U7,R6,D4,L4"
            val expectedDistance = 6

            val distance = runTask01(firstWire, secondWire)!!

            assertThat(distance, equalTo(expectedDistance))
        }

        it("should pass second example from AoC") {
            val firstWire = "R75,D30,R83,U83,L12,D49,R71,U7,L72"
            val secondWire = "U62,R66,U55,R34,D71,R55,D58,R83"
            val expectedDistance = 159

            val distance = runTask01(firstWire, secondWire)!!

            assertThat(distance, equalTo(expectedDistance))
        }

        it("should pass second example from AoC") {
            val firstWire = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"
            val secondWire = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
            val expectedDistance = 135

            val distance = runTask01(firstWire, secondWire)!!

            assertThat(distance, equalTo(expectedDistance))
        }

        it("should solve the task 01") {
            val expectedDistance = 266

            val distance = runTask01()!!

            assertThat(distance, equalTo(expectedDistance))
        }
    }
})