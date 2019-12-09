package com.github.tomjankes.aoc2019.day04

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe


class Day04TaskSpec : Spek({
    describe("day 4 task 2 solution") {
        it ("should have correct answer") {
            assertThat(findNumberOfPossiblePasswordsInRange(136818, 685979), equalTo(1291))
        }
    }
})