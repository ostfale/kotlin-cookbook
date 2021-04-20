package de.ostfale.kotlin.collections.arrays

// two sided waiting list
fun main() {
    val queue = ArrayDeque<Int>()
    queue.addFirst(1) // [1]
    queue.addFirst(2) // [2,1]
    queue.addFirst(3) // [3,2,1]
    queue.addLast(4) // [3,2,1,4]
    println("ArrayDeque = $queue")
    val first = queue.removeFirst()
    val last = queue.removeLast()
    println("Removed first element: $first")
    println("Removed last element: $last")
    println("Remaining ArrayDeque: $queue")
}

