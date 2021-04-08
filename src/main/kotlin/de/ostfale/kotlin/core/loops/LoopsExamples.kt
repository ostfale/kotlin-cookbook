package de.ostfale.kotlin.core.loops

import org.slf4j.LoggerFactory

fun main() {
    LoopsExamples().apply {
        forLoopExample()
        whileLoopExample()
        namedLoop()
        loopWithForEach()
        loopOverArrayExample()
        forRangeExample()
    }
}

class LoopsExamples {

    private val log = LoggerFactory.getLogger(javaClass)

    private val optionsParam = arrayOf("alpha", "beta", "gamma", "delta")

    fun forLoopExample() {
        var x = 1
        for (i in 1..10) {
            x -= i
            log.info("For Loop x  = $x")
        }

        for (item in optionsParam) {
            log.info("$item is an item in an array")
        }

        for (index in optionsParam.indices) {
            log.info("Index $index has item : ${optionsParam[index]}")
        }

        for ((index, item) in optionsParam.withIndex()) {
            log.info("Index $index has item => $item")
        }
    }

    fun whileLoopExample() {
        var x = 3
        while (x < 5) {
            x++
            log.info("While Loop x = $x")
        }
    }

    // Works with break and continue
    fun namedLoop() {
        for (i in 1..2) {
            log.info("i = $i")
            jLoop@ for (j in 1..3) {
                log.info("j = $j")
                for (k in 5..8) {
                    log.info("k = $k")
                    if (k == 7) {
                        break@jLoop;
                    }
                }
            }
        }
    }

    fun loopWithForEach() {
        val seasons = arrayOf("Spring", "Summer", "Autumn", "Winter")
        seasons.forEach { log.info(it) }
        seasons.forEachIndexed { index, s -> log.info("$s is season number $index") }
        for (index in seasons.indices) log.info("${seasons[index]} is season number $index")
    }

    fun loopOverArrayExample() {

        val seasons = arrayOf("Spring", "Summer", "Autumn", "Winter")
        for (season in seasons) log.info(season)

        val notASeason = "whatever" !in seasons
        println(notASeason)

        val notInRange = 32 !in 1..10
        println(notInRange)

        val str = "Hello"
        log.info("Is e in Hello: {}", 'e' in str)
        log.info("Is e not in Hello: {}", 'e' !in str)
    }

    /**
     * Ranges needs to be comparable. Depending on the type there are a lot of library functions around.
     */
    fun forRangeExample() {
        val intRange = 1..5
        val charRange = 'a'..'z'
        val stringRange = "ABC".."XYZ"  // can't loop through since is doesn't have an iterator

        log.info("Is 3 in the range 1..5: {}", 3 in intRange) // true
        log.info("Is q in char range: {}", 'q' in charRange) // true
        log.info("CCCCCC in stringRange: {}", "CCCCCC" in stringRange) // true - less than XYZ even is longer
        log.info("ZZZZZZ in stringRange: {}", "ZZZZZZ" in stringRange) // false - more than XYZ even is longer

        val backwardRange = 5.downTo(1)
        log.info("5 in backwardRange: {}", 5 in backwardRange) // true
        val r = 5..1
        log.info("5 in r: {}", 5 in r) // false < 5 and < 1

        val stepRange = 3..15
        val stepThree = stepRange.step(3)
        val reversedRange = intRange.reversed()

        for (i in intRange) println(i)
        for (n in stepRange) println(n)
        for (n1 in stepThree) println(n1)
        for (n2 in reversedRange) println(n2)

        val str = "Hello"
        for (c in str) println(c)

        for (num in 1..20 step 4) println(num)
        for (i in 20 downTo 10 step 5) println(i)
        for (i in 1 until 10) println(i) // 1 - 9
    }
}