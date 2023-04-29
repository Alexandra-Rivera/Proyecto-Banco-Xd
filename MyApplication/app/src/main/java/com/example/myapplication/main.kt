package com.example.myapplication


/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
    var restart = true
    val bank = Bank()

    while (restart) {

        printMenu()

        when (readln().toInt()) {
            1 -> {

                val newUser = readUserFromKeyboard()
                bank.registerNewUser(newUser)

                val newAccount = readAccountFromKeyboard(newUser)
                bank.addNewAccount(newAccount)

                println("\nLa cuenta fue creada exitosamente")
            }

            2 -> {
                initTransactionFromKeyBoard(bank) { _, _ ->
                    print("Agregar")
                }
            }

            3 -> {
                initTransactionFromKeyBoard(bank) { bankAccount, amount ->
                    bankAccount.removeMoney(amount)
                }
            }

            4 -> {
                val accountList = bank.accounts

                for (account in accountList) {
                    printAccount(account)
                }
            }

            5 -> {
                print("Id de la cuenta: ")
                val account = bank.filterAccount(readln())

                if (account != null) {
                    printAccount(account)
                } else
                    println("\nLa cuenta no existe")

            }

            6 -> {
                restart = false
            }
        }

    }

}

fun printMenu() {
    println("\nBIENVENIDO")
    println("Que desea realizar ? ")
    println("1. Registrarse")
    println("2. Agregar dinero")
    println("3. Retirar dinero")
    println("4. Ver cuentas")
    println("5. Filtrar cuenta")
    println("6. Salir")
    print("\nSeleccion: ")
}

fun printAccount(account: BankAccount) {
    println("\nNombre: ${account.owner.name}")
    println("Apellido: ${account.owner.lastName}")
    println("AccountID: ${account.accountID}")
    println("Monto: ${account.getMoneyAmount()}\n")
}

fun initTransactionFromKeyBoard(bank: Bank, action: (BankAccount, Double) -> Unit) {

    print("AccountID: ")
    val accountID = readln()
    val account = bank.filterAccount(accountID)

    if (account != null) {
        print("Monto: ")
        val amount = readln().toDouble()
        action(account,amount)
    } else {
        println("\nNumero de cuenta incorrecto")
    }

}

fun readUserFromKeyboard(): User {
    print("\nNombre: ")
    val name = readln()

    print("Apellido: ")
    val lastName = readln()

    print("Dui: ")
    val dui = readln().toInt()

    return User(name, lastName, dui)
}

fun readAccountFromKeyboard(owner: User): BankAccount {
    print("AccoundID: ")
    val accountID = readln()

    print("Monto: ")
    val moneyAmount = readln().toDouble()

    return BankAccount(accountID, moneyAmount, owner)
}





