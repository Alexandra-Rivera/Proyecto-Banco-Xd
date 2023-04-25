/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
    var seguir = true
    val bank = Bank()

    while (seguir) {

        println("\nBIENVENIDO")
        println("Que desea realizar ? ")
        println("1. Crear una cuenta")
        println("2. Retirar dinero")
        println("3. Agregar dinero")
        println("4. Salir")
        print("Seleccion: ")

        val userSelection = readln().toInt()

        when (userSelection) {
            1 -> {
                print("\nNombre: ")
                val name = readln()

                print("Apellido: ")
                val lastName = readln()

                print("Dui: ")
                val dui = readln().toInt()

                bank.registerNewUser(name, lastName, dui)

                print("AccoundID: ")
                val accountID = readln()

                print("Monto: ")
                val moneyAmount = readln().toDouble()

                bank.createNewAccount(bank.clientes.last(), accountID, moneyAmount)

                println("\nLa cuenta fue creada exitosamente")
                println(bank.accounts.toString())
            }
            2 -> {
                println("AccountID: ")
                val accountID = readln()
                bank.buscarCuenta(accountID)

                println("Monto: ")
                val monto = readLine()?.toDouble()

                var cuenta = bank.accounts.toString()
            }
            3 -> {
                println("AccountID: ")
                val accountID = readln()
                bank.buscarCuenta(accountID)
            }
            4 -> {
                seguir = false
            }
        }

    }

}

class Bank {

    var clientes = mutableListOf<User>()
    var accounts = mutableListOf<BankAccount>()

    fun createNewAccount(owner: User, accountID: String, moneyAmount: Double) {
        accounts.add(BankAccount(accountID, moneyAmount, owner))
    }

    fun registerNewUser(name: String, lastName: String, dui: Int) {
        clientes.add(User(name, lastName, dui))
    }

    fun buscarCuenta(accountID: String): BankAccount? {
        for (n in accounts) {
            if (n.accountID == accountID)
                return n
        }
        return null
    }

}


data class BankAccount(
    val accountID: String,
    var moneyAmount: Double,
    val owner: User
)


data class User(
    var name: String,
    var lastName: String,
    var dui: Int
)