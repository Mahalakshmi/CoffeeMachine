package machine

class CoffeeMachine {
    var water: Int = 400
    var milk: Int = 540
    var coffeeBean: Int = 120
    var disposableCups: Int = 9
    var totalMoney: Int = 550



    fun printCoffeeMachine(){
        println("""
        The coffee machine has:
        $water ml of water
        $milk ml of milk
        $coffeeBean g of coffee beans
        $disposableCups disposable cups
        ${'$'}$totalMoney of money
    """.trimIndent())
    }

    fun checkAvailability(coffeeType: Int): Boolean {
        var itemsAvailable: Boolean = false
        when(coffeeType) {
            1 -> {
                if (water < Espresso.WATER.value) println("Sorry, not enough water!")
                else if (coffeeBean < Espresso.COFFEE_BEAN.value) println("Sorry, not enough Coffee Bean!")
                else if (disposableCups < Espresso.DISPOSABLE_CUP.value) println("Sorry, not enough Disposable Cups!")
                else itemsAvailable = true
            }
            2 -> {
                if (water < Latte.WATER.value) println("Sorry, not enough water!")
                else if (milk < Latte.MILK.value) println("Sorry, not enough Milk!")
                else if (coffeeBean < Latte.COFFEE_BEAN.value) println("Sorry, not enough Coffee Bean!")
                else if (disposableCups < Latte.DISPOSABLE_CUP.value) println("Sorry, not enough Disposable Cups!")
                else itemsAvailable = true
            }
            3 -> {
                if (water < Latte.WATER.value) println("Sorry, not enough water!")
                else if (milk < Latte.MILK.value) println("Sorry, not enough Milk!")
                else if (coffeeBean < Latte.COFFEE_BEAN.value) println("Sorry, not enough Coffee Bean!")
                else if (disposableCups < Latte.DISPOSABLE_CUP.value) println("Sorry, not enough Disposable Cups!")
                else itemsAvailable = true
            }
        }
        return itemsAvailable
    }

    fun processCofeeOption(coffeeType: Int) {
        when(coffeeType) {
            1 -> {
                water -=  Espresso.WATER.value
                coffeeBean -=  Espresso.COFFEE_BEAN.value
                disposableCups -=  Espresso.DISPOSABLE_CUP.value
                totalMoney +=  Espresso.COST.value
            }
            2 -> {
                water -=  Latte.WATER.value
                milk -= Latte.MILK.value
                coffeeBean -= Latte.COFFEE_BEAN.value
                disposableCups -= Latte.DISPOSABLE_CUP.value
                totalMoney += Latte.COST.value
            }
            3 -> {
                water -= Cappuccino.WATER.value
                milk -= Cappuccino.MILK.value
                coffeeBean -= Cappuccino.COFFEE_BEAN.value
                disposableCups -= Cappuccino.DISPOSABLE_CUP.value
                totalMoney += Cappuccino.COST.value
            }
        }
        println("I have enough resources, making you a coffee!")
    }

}

