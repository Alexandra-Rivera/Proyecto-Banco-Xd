package com.example.myapplication.morepractice

fun main () {
    val animalList = mutableListOf<String>()
    var restart = true

    while (restart) {
        print("Ingrese el nombre de un animal: ")
        val animal: String = readln()

        animalList.add(animal)

        if(animal == ""){
            restart = false
        }
    }
    println(animalList)
}
