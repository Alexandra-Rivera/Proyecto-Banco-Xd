package com.example.myapplication

fun main ( ) {

    var restart = true
    val catMainObject = catRegister()

    while (restart) {
        println("\nWelcome! We love kitty's here!")
        println("Help us build a list full of data of our beloved little ones!!!!")
        println("1. Add one little one")
        println("2. Check the list")
        println("3. Change my cat's name")
        println("4. Leave\n")

        print("Selection: ")
        val userSelection = readln()

        when (userSelection) {
            "1" -> {
                val newPurry = enteraNewCat()
                catMainObject.addToTheCatList(newPurry)
            }

            "2" -> {

                for (cat in catMainObject.catList) {
                        println("\nName: ${cat.name}")
                        println("Fur color: ${cat.furColor}")
                        println("Type: ${cat.getCatType()}")
                        println("Eye color: ${cat.getCatEyeColor()}")
                }

            }
            "3" -> {
                println("Enter the id of your cat: ")
                val catId = readln().toInt()

                val cat = catMainObject.filterListItem(catId)

                if (cat != null) {
                    print("\nEnter the new name of your cat: ")
                    val newName = readln()

                    cat.name = newName

                    println("Cambios realizados!!")
                    println(cat)
                } else
                    println("El id ingresado no concuerda con ninguna de las cuentas")

            }
            "4" -> {
                restart = false
            }
        }
    }


}

fun enteraNewCat(): Cat {
    print("Add a number: ")
    val catId = readln().toInt()

    print("Name: ")
    val catName = readln()

    print("Fur color: ")
    val furColor = readln()

    print("Type: ")
    val type = readln()

    print("Eye color: ")
    val eyeColor = readln()

    return Cat(catId, catName, furColor, type, eyeColor)
}

class catRegister() {
    var catList = mutableListOf<Cat>()

    fun addToTheCatList(cat: Cat) {
        catList.add(cat)
    }

    fun filterListItem (catId: Int): Cat? {
        for (catid in catList) {
            catid.id = catId
            return catid
        }
        return null
    }
}

data class Cat (
    var id: Int,
    var name: String,
    var furColor: String,
    private var type: String,
    private var eyeColor: String
        ) {
    fun addAnotherName(name: String ) {
        this.name = name
    }

    fun changeFurColor ( ) {

    }

    fun getCatEyeColor() = eyeColor

    fun getCatType() = type
}

