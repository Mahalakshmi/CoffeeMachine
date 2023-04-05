package machine

import kotlin.math.min

var exit: Boolean = true

fun main() {

    val coffeeMachine: CoffeeMachine = CoffeeMachine()

    while (exit) {
        println("Write action (buy, fill, take, remaining, exit): ")
        val action: String = readln()
        when (action) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
                val data: String = readln()
                if(data.equals("back")) continue else {
                    val coffeeOption: Int = data.toInt()
                    if(coffeeMachine.checkAvailability(coffeeOption)) coffeeMachine.processCofeeOption(coffeeOption)
                }
            }
            "fill" -> {
                println("Write how many ml of water you want to add: ")
                coffeeMachine.water += readln().toInt()
                println("Write how many ml of milk you want to add: ")
                coffeeMachine.milk += readln().toInt()
                println("Write how many grams of coffee beans you want to add:")
                coffeeMachine.coffeeBean += readln().toInt()
                println("Write how many disposable cups you want to add:")
                coffeeMachine.disposableCups += readln().toInt()
            }
            "take" -> {
                println("I gave you ${'$'}$coffeeMachine.totalMoney")
                coffeeMachine.totalMoney = 0
            }
            "remaining" -> {
                coffeeMachine.printCoffeeMachine()
            }
            "exit" -> {
                exit = false
            }
        }
    }
}







fun CoffeeProcess(water: Int, milk: Int, coffeeBean: Int, totalCupsReq: Int) {
    println("Write how many ml of water the coffee machine has:")
    val waterQty: Int = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val milkQty: Int = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val coffeeBeanQty: Int = readln().toInt()
    println("Write how many cups of coffee you will need:")
    val coffeCupReq: Int = readln().toInt()

    val availableWater: Int = water / CoffeIngredients.WATER.quantity
    val availableMilk: Int = milk / CoffeIngredients.MILK.quantity
    val availableCoffeeBean: Int = coffeeBean / CoffeIngredients.COFFEE_BEAN.quantity

    val minimumCoffeeCount = min( min(availableWater, availableMilk), availableCoffeeBean)

    println( if (minimumCoffeeCount < totalCupsReq) "No, I can make only $minimumCoffeeCount cups of coffee"
    else if ( minimumCoffeeCount > totalCupsReq) "Yes, I can make that amount of coffee (and even ${minimumCoffeeCount - totalCupsReq} more than that)"
    else "Yes, I can make that amount of coffee")
}

fun coffeeRecipe(): String {
    return """
            Starting to make a coffee
Grinding coffee beans
Boiling water
Mixing boiled water with crushed coffee beans
Pouring coffee into the cup
Pouring some milk into the cup
Coffee is ready!"""
}

fun coffeeCount() {
    println("Write how many cups of coffee you will need:")
    val coffeeCount = readln()?.toInt()
    println("${CoffeIngredients.WATER.quantity * coffeeCount} ml of water")
    println("${CoffeIngredients.MILK.quantity * coffeeCount} ml of milk")
    println("${CoffeIngredients.COFFEE_BEAN.quantity * coffeeCount} g of coffee beans")
}