package com.github.tomjankes.aoc2019.day02

import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

fun contentEquals(expected: IntArray) : Matcher<IntArray> {
    val contentAsString = expected.joinToString(",", "[", "]")
    return Matcher.Companion("Content equals $contentAsString") {
        actual ->  actual.contentEquals(expected)
    }
}

class IntcodeProgramSpec : Spek({
    describe("int code program") {
        mapOf(
            "1,0,0,0,99" to intArrayOf(2,0,0,0,99),
            "2,3,0,3,99" to intArrayOf(2,3,0,6,99),
            "2,4,4,5,99,0" to intArrayOf(2,4,4,5,99,9801),
            "1,1,1,4,99,5,6,0,99" to intArrayOf(30,1,1,4,2,5,6,0,99)
        ).forEach { (input, expected) ->
            it ("for $input should return $expected") {
                //when
                val actual = run(input)
                //then
                assertThat(actual, contentEquals(expected))
            }
        }

        it("should correctly calculate first element for input") {
            //given
            val correctResult = 4570637
            //when
            val result = runTask02()
            //then
            assertThat(result, equalTo(correctResult))
        }
    }
})