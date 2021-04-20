package de.ostfale.kotlin.collections.map

fun main() {
    initSequences()
    generateSeqEx()
    sequenceExamples()
    lazySeqExample()
}

fun generateSeqEx() {
    val seqEndless = generateSequence { 0 }  // endless 0 sequence
    val seqRandom = generateSequence { (0..10).random() }
    println("First 5 elements of 0 sequence: ${seqEndless.take(5).toList()}")
    println("First 5 elements of random sequence: ${seqRandom.take(5).toList()}")
}

fun initSequences() {
    val seq = sequenceOf(41, 42, 43)

    val lst = listOf(3, 5, 7)
    val seqBuild = sequence {
        yield(2)
        yieldAll(lst)
        yield(11)
    }
    println("Build Sequence: ${seqBuild.toList()}")
}

fun lazySeqExample() {
    val seq = generateSequence(0) { it + 1 }
    val seq1 = seq.map { it * 3 + 27 }
    val seq2 = seq1.filter { it > 1000 }
    println("Lazy sequence evaluation: " + seq2.take(5).toList())
}

fun sequenceExamples() {
    val seq = sequenceOf(1, 2, 3, 4)
    val seq2 = seq.map { it * it }
    for (s in seq) println("Seq. elements: $s")
    for (s in seq2) println("Seq.  elements: $s")
    println("Seq. sum: ${seq.sum()}")
    println("Seq. count: ${seq.count()}")
}
