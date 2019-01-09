package day1

import java.io.File

private const val DAY1_INPUT_PATH = "src/day1/day1.txt"

fun main(args: Array<String>) {
    println("Day 1 part 1 answer: ${solveDay1Part1()}")
    println("Day 1 part 2 answer: ${solveDay1Part2()}")
}

fun solveDay1Part1(): Int =
    File(DAY1_INPUT_PATH).useLines { it.toList() }.fold(0){sum, element -> sum + element.toInt()}

fun solveDay1Part2(): Int {
    val list = File(DAY1_INPUT_PATH).useLines { it.toList() }
    val set = HashSet<Int>()
    var sum = 0
    set.add(sum)
    var i = 0
    while (true) {
        if (i >= list.size) {
            i = 0
        }
        sum += list[i].toInt()
        if (set.contains(sum)) {
            return sum
        }
        set.add(sum)
        i++
    }
}