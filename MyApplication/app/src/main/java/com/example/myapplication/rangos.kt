package com.example.myapplication


fun main(){

    saludar("Te saludo"){ mirada: String, boca: String ->
        println("$mirada")
        println("$boca")
    }

}

fun saludar(saludame: String,expresion: (mirada: String, boca: String) -> Unit) {
    print(saludame)
    expresion("Enojada", "Hacia abajo")
}
