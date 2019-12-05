package com.github.tomjankes.aoc2019.day01

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class CalculateFuelSpec : Spek({
    describe("calculateFuel function") {
        mapOf(
            12 to 2,
            14 to 2,
            1969 to 654,
            100756 to 33583
        ).forEach { (input, expected) ->
            it("should calculate $expected for $input") {
                //when
                val calculatedFuel = calculateFuel(input)
                //then
                assertThat(calculatedFuel, equalTo(expected))
            }
        }
    }

    mapOf(
        12 to 2,
        14 to 2,
        1969 to 966,
        100756 to 50346
    ).forEach { (input, expected) ->
        describe("calculateFuelFuel function") {
            it("should calculate $input for $expected") {
                //when
                val calculatedFuel = calculateFuelFuel(input)
                //then
                assertThat(calculatedFuel, equalTo(expected))
            }
        }

        describe("tailRecursiveCalculateFuelFuel function") {
            it("should calculate $input for $expected") {
                //when
                val calculatedFuel = calculateFuelFuel(input)
                //then
                assertThat(calculatedFuel, equalTo(expected))
            }
        }
    }

    val correctAnswer = 5148724

    describe("tail recursive solution") {
        it("should give correct answer") {
            //when
            val answer = runTask01 { tailRecursiveCalculateFuel(it) }
            //then
            assertThat(answer, equalTo(correctAnswer))
        }
    }

    describe("imperative solution") {
        it("should give correct answer") {
            //when
            val answer = runTask01 { calculateFuelFuel(it) }
            //then
            assertThat(answer, equalTo(correctAnswer))
        }
    }
})