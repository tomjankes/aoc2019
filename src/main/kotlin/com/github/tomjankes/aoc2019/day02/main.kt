package com.github.tomjankes.aoc2019.day02

import com.github.tomjankes.aoc2019.getFile

const val OPCODE_ADD = 1
const val OPCODE_MULTIPLY = 2
const val OPCODE_EXIT = 99

tailrec fun run(program: IntArray, pos: Int = 0) : IntArray {
    when(val currentOpcode = program[pos]) {
        OPCODE_ADD -> program[program[pos + 3]] = program[program[pos + 1]] + program[program[pos + 2]]
        OPCODE_MULTIPLY -> program[program[pos + 3]] = program[program[pos + 1]] * program[program[pos + 2]]
        OPCODE_EXIT -> return program
        else -> throw IllegalArgumentException("Incorrect opcode $currentOpcode on position $pos")
    }
    return if (pos >= program.size) {
        program
    } else {
        run(program, pos + 4)
    }
}

fun String.toIntArray() = this.split(',').map { it.toInt() }.toIntArray()

fun run(program: String) : IntArray = run(program.toIntArray())
fun runTask(program: IntArray, noun: Int, verb: Int): IntArray {
    program[1] = noun
    program[2] = verb
    return run(program)
}
fun runTask01(noun: Int, verb: Int) : Int = runTask("input02.txt".getFile().readText().toIntArray(), noun, verb)[0]
fun runTask01() : Int = runTask01(12, 2)

data class Task02Result(
    val noun: Int,
    val verb: Int
) {
    val answer = 100 * noun + verb
    override fun toString(): String = "Noun: $noun, verb: $verb, answer: $answer"
}

fun runTask02() : Task02Result? {
    val initialProgram = "input02.txt".getFile().readText().toIntArray()
    val desiredOutput = 19690720

    for (noun in 99 downTo 0) {
        for (verb in 0..99) {
            val program = initialProgram.clone()
            val output = runTask(program, noun, verb)[0]
            if (output == desiredOutput) {
                return Task02Result(noun, verb)
            }
        }
    }
    return null
}

fun main() {
    println(runTask02())
}