package de.ostfale.kotlin.errors.tryexample

typealias ResultSet<T> = Pair<List<Success<T>>, List<Failure<T>>>

sealed class Try<T> {

    /**
     * The sealed class Try has a companion object which implements invoke, which allows you to call Try as if
     * you would call its constructor, which is not necessarily required but makes it more expressive.
     */
    companion object {
        operator fun <T> invoke(func: () -> T): Try<T> =
            try {
                Success(func())
            } catch (error: Exception) {
                Failure(error)
            }

        object TrySequence {
            operator fun <T> Try<T>.component1(): T = when (this) {
                is Success -> this.value
                is Failure -> throw this.error
            }
        }

        fun <T> sequential(func: TrySequence.() -> T): Try<T> = Try { func(TrySequence) }
    }


    abstract fun <R> map(transform: (T) -> R): Try<R>
    abstract fun <R> flatMap(func: (T) -> Try<R>): Try<R>
    abstract fun <R> recover(transform: (Exception) -> R): Try<R>
    abstract fun <R> recoverWith(transform: (Exception) -> Try<R>): Try<R>
}


class Success<T>(val value: T) : Try<T>() {

    override fun <R> map(transform: (T) -> R): Try<R> = Try { transform(value) }

    override fun <R> flatMap(func: (T) -> Try<R>): Try<R> =
        Try { func(value) }.let {
            when (it) {
                is Success -> it.value
                is Failure -> it as Try<R>
            }
        }

    override fun <R> recover(transform: (Exception) -> R): Try<R> = this as Try<R>
    override fun <R> recoverWith(transform: (Exception) -> Try<R>): Try<R> = this as Try<R>

    override fun toString(): String {
        return "Success(${value.toString()})"
    }
}

class Failure<T>(val error: Exception) : Try<T>() {
    override fun <R> map(transform: (T) -> R): Try<R> = this as Try<R>
    override fun <R> flatMap(func: (T) -> Try<R>): Try<R> = this as Try<R>

    override fun <R> recover(transform: (Exception) -> R): Try<R> = Try { transform(error) }
    override fun <R> recoverWith(transform: (Exception) -> Try<R>): Try<R> = Try { transform(error) }.let {
        when (it) {
            is Success -> it.value
            is Failure -> it as Try<R>
        }
    }

    override fun toString(): String {
        return "Failure(${error.message})"
    }
}

/**
 * Traverse is commonly some sort of operation used when encountering collections and basically allows us to collapse
 * a List<Try<T>> into a Try<List<T>> giving you a Success with a List only if all operations succeeded or a failure
 * if any operation failed.
 */
fun <T, R> Try.Companion.traverse(list: List<T>, transform: (T) -> Try<R>): Try<List<R>> = Try {
    val newList = mutableListOf<R>()
    for (value in list) {
        when (val result = transform(value)) {
            is Success -> newList.add(result.value)
            is Failure -> throw result.error
        }
    }
    newList
}

/**
 * A partition, on the other hand, would give you a Pair with two Lists, one with all Successes and one with all
 * Failures, so a Pair<List<Success>, List<Failure>>>, which allows you to keep results as well as errors and
 * handle both separately and when and how you want to.
 */
fun <T> List<Try<T>>.asResultSet(): ResultSet<T> = this.partition { it is Success } as ResultSet<T>

fun <T, R> ResultSet<T>.map(transform: (T) -> R): ResultSet<R> =
    this.first.map { it.map(transform) }.asResultSet().let { result ->
        Pair(result.first, this.second as List<Failure<R>> + result.second)
    }