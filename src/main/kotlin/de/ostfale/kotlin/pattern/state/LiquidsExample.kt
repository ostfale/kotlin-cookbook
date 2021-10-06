package de.ostfale.kotlin.pattern.state

sealed class LiquidState{
    object Solid: LiquidState()
    object Liquid: LiquidState()
    object Gas: LiquidState()
}

sealed class LiquidEvent{
    object OnMelted: LiquidEvent()
    object OnFroze: LiquidEvent()
    object OnVaporized: LiquidEvent()
    object OnCondensed: LiquidEvent()
}

sealed class SideEffect{
    object LogMelted: SideEffect()
    object LogFrozen: SideEffect()
    object LogVaporized: SideEffect()
    object LogCondensed: SideEffect()
}