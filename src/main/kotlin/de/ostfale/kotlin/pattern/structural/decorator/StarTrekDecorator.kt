package de.ostfale.kotlin.pattern.structural.decorator

interface StarTrekRepository {
    // use set and get to have operator overloading
    operator fun get(starshipName: String): String
    operator fun set(starshipName: String, captainName: String)
}

class DefaultStarTrekRepository : StarTrekRepository {
    private val starshipCaptains = mutableMapOf("USS Enterprise" to "Jean-Luc Picard")

    override fun get(starshipName: String): String {
        return starshipCaptains[starshipName] ?: "Unknown"
    }

    override fun set(starshipName: String, captainName: String) {
        starshipCaptains[starshipName] = captainName
    }
}

class LoggingGetCaptain(private val repository: StarTrekRepository) : StarTrekRepository by repository {
    override fun get(starshipName: String): String {
        println("Getting captain for $starshipName")
        return repository[starshipName]
    }
}

class ValidatingAdd(private val repository: StarTrekRepository) : StarTrekRepository by repository {
    private val maxNameLength = 15
    override fun set(starshipName: String, captainName: String) {
        require(captainName.length < maxNameLength) {
            "$captainName name is longer than $maxNameLength characters!"
        }
        repository[starshipName] = captainName
    }
}

fun main() {
    val starTrekRepository = DefaultStarTrekRepository()
    // first wrap (decorator)
    val withValidating = ValidatingAdd(starTrekRepository)
    // second wrap (decorator)
    val withLoggingAndValidating = LoggingGetCaptain(withValidating)
    withLoggingAndValidating["USS Enterprise"]

    println(withLoggingAndValidating is LoggingGetCaptain) // This is our top level decorator, no problem here
    println(withLoggingAndValidating is StarTrekRepository) // This is the interface we implement, still no problem
    //println(withLoggingAndValidating is ValidatingAdd) // We wrap this class, but compiler cannot validate it
    //println(withLoggingAndValidating is DefaultStarTrekRepository) // We wrap this class, but compiler cannot validate it

    try {
        // Throws an exception: Kathryn Janeway name is longer than 15 characters!
        withLoggingAndValidating["USS Voyager"] = "Kathryn Janeway"
    } catch (e: IllegalStateException) {
        println(e)
    }

}
