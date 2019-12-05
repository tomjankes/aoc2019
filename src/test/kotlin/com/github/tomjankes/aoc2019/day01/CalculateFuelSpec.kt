package com.github.tomjankes.aoc2019.day01

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class CalculateFuelSpec : Spek({
    describe("calculateFuel function") {
        listOf(
            Pair(12, 2),
            Pair(14, 2),
            Pair(1969, 654),
            Pair(100756, 33583)
        ).forEach {
            it("should calculate ${it.second} for ${it.first}") {
                //given
                val (input, expected) = it
                //when
                val calculatedFuel = calculateFuel(input)
                //then
                assertThat(calculatedFuel, equalTo(expected))
            }
        }
    }

    listOf(
        Pair(12, 2),
        Pair(14, 2),
        Pair(1969, 966),
        Pair(100756, 50346)
    ).forEach {
        describe("calculateFuelFuel function") {
            it("should calculate ${it.second} for ${it.first}") {
                //given
                val (input, expected) = it
                //when
                val calculatedFuel = calculateFuelFuel(input)
                //then
                assertThat(calculatedFuel, equalTo(expected))
            }
        }

        describe("tailRecursiveCalculateFuelFuel function") {
            it("should calculate ${it.second} for ${it.first}") {
                //given
                val (input, expected) = it
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