package com.example.myapplication

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
    var restart = true
    val bank = Bank()

    while (restart) {

        println("\nBIENVENIDO")
        println("Que desea realizar ? ")
        println("1. Registrarse")
        println("2. Agregar dinero")
        println("3. Retirar dinero")
        println("4. Ver cuentas")
        println("5. Filtrar cuenta")
        println("6. Salir")
        print("\nSeleccion: ")

        val userSelection = readln().toInt()

        when (userSelection) {
            1 -> {

                val newUser = readUserFromKeyboard()
                bank.registerNewUser(newUser)

                val newAccount= readAccountFromKeyboard(newUser)
                bank.addNewAccount(newAccount)

                println("\nLa cuenta fue creada exitosamente")
            }
            2 -> {
                print("AccountID: ")
                val accountID = readln()
                val account = bank.filterAccount(accountID)

                if(account != null) {
                    print("Monto: ")
                    val amount = readLine()!!.toDouble()
                    account.addMoney(amount)
                } else {
                    println("Numero de cuenta incorrecto")
                }

            }
            3 -> {
                println("AccountID: ")
                val accountID = readln()
                val account = bank.filterAccount(accountID)

                if(account != null) {
                    println("Monto: ")
                    val amount = readLine()!!.toDouble()
                    account.removeMoney(amount)
                } else {
                    println("\nNumero de cuenta incorrecto")
                }
            }
            4 -> {
                val accountList = bank.accounts

                for(account in accountList){
                    println("\nNombre: ${account.owner.name}")
                    println("Apellido: ${account.owner.lastName}")
                    println("AccountID: ${account.accountID}")
                    println("Monto: ${account.getMoneyAmount()}\n")
                }
            }
            5 -> {
                print("Id de la cuenta: ")
                val account = bank.filterAccount(readln())

                if (account != null ){
                    println("\nNombre: ${account.owner.name}")
                    println("Apellido: ${account.owner.lastName}")
                    println("ID: ${account.accountID}")
                    println("Saldo actual: ${account.getMoneyAmount()}")
                } else
                    println("\nLa cuenta no existe")

            }
            6 -> {
                restart = false
            }
            else -> {
                println("\nLa selección no existe dentro del menú")
            }
        }

    }

}

fun readUserFromKeyboard(): User {
    print("\nNombre: ")
    val name = readln()

    print("Apellido: ")
    val lastName = readln()

    print("Dui: ")
    val dui = readln().toInt()

    return User(name,lastName,dui)
}

fun readAccountFromKeyboard(owner: User): BankAccount {
    print("AccoundID: ")
    val accountID = readln()

    print("Monto: ")
    val moneyAmount = readln().toDouble()

    return BankAccount(accountID, moneyAmount, owner)
}

class Bank {
    var clients = mutableListOf<User>()
    var accounts = mutableListOf<BankAccount>()

    fun addNewAccount(account: BankAccount) {
        accounts.add(account)
    }

    fun registerNewUser(user: User) {
        clients.add(user)
    }

    fun filterAccount(accountID: String): BankAccount? {
        for (account in accounts) {
            if (account.accountID == accountID)
                return account
        }
        return null
    }

}


data class BankAccount(
    val accountID: String,
    private var moneyAmount: Double,
    val owner: User
) {
    fun addMoney(money: Double) {
        if (money <= 0) {
            throw Exception("Cantidad incorrecta a depositar, no se permiten valores negativos o 0")
        }
        this.moneyAmount =+ money
    }

    fun removeMoney(money: Double ){
        if(moneyAmount - money < 0) {
            throw Exception("Saldo insuficiente")
        }
        this.moneyAmount -= money
    }

    fun getMoneyAmount() = moneyAmount
}


data class User(
    var name: String,
    var lastName: String,
    var dui: Int
)