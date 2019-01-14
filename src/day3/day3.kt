package day2

import java.io.File
import java.util.regex.Pattern

private const val DAY3_INPUT_PATH = "src/day3/day3.txt"

fun main(args: Array<String>) {
    println("Day 3 part 1 answer: ${solveDay3Part1()}")
//    println("Day 3 part 2 answer: ${solveDay3Part2()}")
}

fun solveDay3Part1(): Int {
    val list = File(DAY3_INPUT_PATH).useLines { it.toList() }
    val array = Array(1000) {IntArray(1000)}
    var result = 0
    for (i in 0 until 1000) {
        for (j in 0 until 1000) {
            array[i][j] = 0
        }
    }
    list.forEach { string ->
        val p = Pattern.compile("\\d+")
        val m = p.matcher(string)
        val dimArray = ArrayList<Int>(4)
        while (m.find()) {
            dimArray.add(m.group().toInt())
        }
        // Remove first redundant number
        dimArray.removeAt(0)
        for (i in dimArray[0] until dimArray[0] + dimArray[2]) {
            for (j in dimArray[1] until dimArray[1] + dimArray[3]) {
                array[i][j] += 1
            }
        }
    }
    for (i in 0 until 1000) {
        for (j in 0 until 1000) {
            if (array[i][j] > 1) {
                result++
            }
        }
    }
    return result
}

//fun solveDay3Part2(): String {
//    val list = File(DAY3_INPUT_PATH).useLines { it.toList() }
//    var result = ""
//    list.forEach { firstString ->
//        var differentCharCount = 0
//        list.subList(1, list.size).forEach {secondString ->
//            var _index = -1
//            differentCharCount = 0
//            firstString.forEachIndexed {index, char ->
//                if (char != secondString[index]) {
//                    _index = index
//                    differentCharCount++
//                }
//            }
//            if (differentCharCount == 1) {
//                result = firstString.substring(0, _index) + firstString.substring(_index + 1, firstString.length)
//                return result
//            }
//        }
//    }
//    return result
//}