package com.example.myapplication

data class BankAccount(
    val accountID: String,
    private var moneyAmount: Double,
    val owner: User
) {
    fun addMoney(money: Double) {
        if (money <= 0) {
            throw Exception("Cantidad incorrecta a depositar, no se permiten valores negativos o 0")
        }
        this.moneyAmount = +money
    }

    fun removeMoney(money: Double) {
        if (moneyAmount - money < 0) {
            throw Exception("Saldo insuficiente")
        }
        this.moneyAmount -= money
    }

    fun getMoneyAmount() = moneyAmount
}