package de.ostfale.kotlin.pattern.state

sealed class State
object s0 : State()
object s1 : State()

val a = Input("press")

// Link: part 1: https://sp4ghetticode.medium.com/finite-state-machines-in-kotlin-part-1-57e68d54d93b
// Link: part 2: https://sp4ghetticode.medium.com/writing-finite-state-machines-in-kotlin-part-2-delta-hat-3f2ae5eb42bd

data class Input(val value: String)
data class DFA(
    val states: Set<State>,
    val inputs: Set<Input>,
    val delta: (State, Input) -> State,
    val initialState: State,
    val isFinaleState: (State) -> Boolean
)

val dfa = DFA(
    states = setOf(s0, s1),
    inputs = setOf(a),
    delta = { state: State, input: Input ->
        when (input) {
            a -> when (state) {
                s0 -> s1
                s1 -> s0
            }
            else -> state
        }
    },
    initialState = s0,
    isFinaleState = { state: State -> state == s1 }
)