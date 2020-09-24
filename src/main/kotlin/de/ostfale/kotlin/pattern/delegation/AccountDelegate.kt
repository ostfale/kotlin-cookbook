package de.ostfale.kotlin.pattern.delegation

interface AccountType {
    var balance: Float
    val rate: Float

    fun calculateInterest(): Float
}

class AccountTypeImpl(override var balance: Float = 0f) : AccountType {
    override val rate: Float = 0.05f
    override fun calculateInterest(): Float = balance * rate
}

class MoneyMarket(delegate: AccountType) : AccountType by delegate

class Stocks(delegate: AccountType) : AccountType by delegate {
    override fun calculateInterest(): Float = balance * rate * 1.3f
}

fun main() {
    val moneyMarketAccount = MoneyMarket(AccountTypeImpl(100f))
    val stockMarketAccount = Stocks(AccountTypeImpl(100f))

    println("Market account interest: ${moneyMarketAccount.calculateInterest()}")
    println("Stock account interest: ${stockMarketAccount.calculateInterest()}")
}
