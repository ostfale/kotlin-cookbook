package de.ostfale.kotlin.generics.reified

// https://kotlin.christmas/2020/10

inline fun <reified G : Any> simpleGenericFunctionWithoutBounds(thing: G): G {
    print(G::class)
    return thing
}

fun main() {
    simpleGenericFunctionWithoutBounds(ExtendableClass())
}

class ExtendableClass()