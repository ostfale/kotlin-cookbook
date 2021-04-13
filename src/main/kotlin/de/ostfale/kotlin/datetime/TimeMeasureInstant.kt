package de.ostfale.kotlin.datetime

import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import kotlin.math.sin

fun main() {
    instantToLocalDateTime()
    durationExample()
}

fun durationExample() {
    val instStart = Instant.now()
    for (i in (0..1_000_000)) sin(i.toDouble())
    val instStop = Instant.now()
    val dur = Duration.between(instStart, instStop)
    println("Duration to cal 1 Mio. sin functions : $dur (nanos: ${dur.toNanos()})")
}

fun instantToLocalDateTime() {
    val inst = Instant.now()
    val ldt = LocalDateTime.ofInstant(inst, ZoneId.systemDefault())
    println("Instant: $inst and LDT: $ldt")
}
