package com.example.myapplication.morepractice

fun main() {
    var washingMachinesList = mutableListOf<washingMachines>()
    var restart = true

    while (restart){
        println("\nIngrese los datos siguientes")
        val newWashingMachine = creatingNewWashingMachine()

        if (newWashingMachine != null) {
            washingMachinesList.add(newWashingMachine)
            restart = stopMenu(restart)

        } else {
            println("\nNo se creo la washingMachine")
            println("Por favor intente de nuevo.")
            creatingNewWashingMachine()
        }
    }

    println(washingMachinesList)
}

fun creatingNewWashingMachine(): washingMachines? {
    print("\nSize: ")
    val size = readln()
    if (size != ""){
        print("Color: ")
        val color = readln()

        if (color != ""){

            print("Brand: ")
            val brand = readln()

            if (brand != ""){

                print("Capacity: ")
                val capacity = readln()

                if (capacity != ""){
                    return washingMachines(size, color, brand, capacity)
                } else
                    return null
            } else
                return null
        } else
            return null
    } else
        return null
}

fun stopMenu(restart: Boolean): Boolean {
    println("\nDesea agregar otra washingMachine? ")
    println("1. Si")
    println("2. No")

    if (readln().toInt() == 2){
        return false
    }
    if(readln() == "") {
        println("No se puede ingresar texto")
        return false
    }

    return if (readln().toInt() != 1){
        println("La opcion no existe dentro del menu")
        false
    } else
        restart
}

data class washingMachines(
    var size: String,
    var color: String,
    var brand: String,
    var capacity: String
)