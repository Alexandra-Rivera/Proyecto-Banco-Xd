package com.example.myapplication

fun main () {
    var cadena1 : String? = null
    var cadena2 : String? = "Nombre"

    if (cadena1 != null){
        println("cadena1 almacena $cadena1")
    } else
        println("cadena1 apunta a nulo")

    if (cadena2 != null ){
        println("cadena2 almacena $cadena2")
    } else
        println("cadena2 apunta a nulo")
}