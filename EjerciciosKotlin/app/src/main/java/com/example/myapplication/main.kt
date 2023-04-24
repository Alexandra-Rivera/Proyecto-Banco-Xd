/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */


///NOTAS
/*
* Introducir las variables de createNewAccount en CreateNewUser y llenar las variables ahi
* Llamar a la funcion de CreateNewUser en CreateNewAccount para crear ese constructor
* */



fun main() {

    //Menu
    println("\nBIENVENIDO")
    println("¿Qué necesita realizar?")
    println("1. Crear cuenta")
    println("2. Retirar dinero")
    print("Ingrese el numero de su seleccion: ")

    val userSelection = readln().toInt()

    if (userSelection == 1){
        Bank().CreateNewUser()
    }else if (userSelection == 2){
        println("Funcion todavia no creada :p")
    }

}

class Bank {
    //Funciones de banco
    //Retirar dinero

    fun CreateNewAccount() {
        //val userID: Int
        val accountNumber: Int
        val moneyAmount: Double
        val ownerDui: Int


        print("Ingrese su numero de dui: ")
        ownerDui = readln().toInt()

        print("Monto Inicial: ")
        moneyAmount = readln().toDouble()
        if (moneyAmount >= 25.0){
            println("El monto inicial debe ser de al menos $25.00")
            //Debe permitirle volver a ingresar este dato
        }

        /*
        * Crear generador de numeros para el num de cuenta
        *
        * */

        //Como puedo linkear esta cuenta con el usuario correspondiente al crear una nueva cuentaa
        //DUDA: Aqui haria falta una bdd (?)
    }

    fun CreateNewUser() {
        val name: String
        val lastName: String
        val dui: Int

        print("\nNombre: ")
        name = readln()

        print("Apellido: ")
        lastName = readln()

        print("Dui: ")
        dui = readln().toInt()

        User(name, lastName, dui)


    }
}


data class BankAccount (
    val accountID:String,
    val moneyAmount: Double,
    val ownerDui: User
)


data class User(
    var name: String,
    var lastName: String,
    var dui: Int
)
