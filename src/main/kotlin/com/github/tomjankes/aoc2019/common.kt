package com.github.tomjankes.aoc2019

import java.io.File

fun String.getFile(): File {
    val fileUri = object {}.javaClass.classLoader?.getResource(this)?.toURI()!!
    return File(fileUri)
}
