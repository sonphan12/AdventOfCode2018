package day2

import java.io.File

private const val DAY2_INPUT_PATH = "src/day2/day2.txt"

fun main(args: Array<String>) {
    println("Day 2 part 1 answer: ${solveDay2Part1()}")
    println("Day 2 part 2 answer: ${solveDay2Part2()}")
}

fun solveDay2Part1(): Int {
    val list = File(DAY2_INPUT_PATH).useLines { it.toList() }
    var twoLettersCounter = 0
    var threeLettersCounter = 0
    list.forEach {string ->
        val hashMap = HashMap<Char, Int>()
        string.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        twoLettersCounter += if (hashMap.filter { it.value == 2 }.isNotEmpty()) 1 else 0
        threeLettersCounter += if (hashMap.filter { it.value == 3 }.isNotEmpty()) 1 else 0
    }
    return twoLettersCounter * threeLettersCounter
}

fun solveDay2Part2(): String {
    val list = File(DAY2_INPUT_PATH).useLines { it.toList() }
    var result = ""
    list.forEach { firstString ->
        var differentCharCount = 0
        list.subList(1, list.size).forEach {secondString ->
            var _index = -1
            differentCharCount = 0
            firstString.forEachIndexed {index, char ->
                if (char != secondString[index]) {
                    _index = index
                    differentCharCount++
                }
            }
            if (differentCharCount == 1) {
                result = firstString.substring(0, _index) + firstString.substring(_index + 1, firstString.length)
                return result
            }
        }
    }
    return result
}