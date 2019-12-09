package com.github.tomjankes.aoc2019.day04

import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.assertion.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class PasswordSpec : Spek({

    val isValidPasswordMatcher = Matcher.Companion(::isValidPassword)

    describe("Password validator") {
        it("should indicate invalid for 111111") {
            assertThat(111111, !isValidPasswordMatcher)
        }

        it("should indicate invalid for 223450") {
            assertThat(223450, !isValidPasswordMatcher)
        }

        it("should indicate invalid for 123789") {
            assertThat(123789, !isValidPasswordMatcher)
        }

        it("should indicate valid for 112233") {
            assertThat(112233, isValidPasswordMatcher)
        }

        it("should indicate invalid for 123444") {
            assertThat(123444, !isValidPasswordMatcher)
        }

        it("should indicate valid for 111122") {
            assertThat(111122, isValidPasswordMatcher)
        }

        it("should indicate valid for 112222") {
            assertThat(112222, isValidPasswordMatcher)
        }

    }
})