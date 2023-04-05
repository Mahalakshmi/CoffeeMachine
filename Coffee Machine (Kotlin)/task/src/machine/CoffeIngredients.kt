package machine

enum class CoffeIngredients(val quantity: Int) {
        WATER(200),
        MILK(50),
        COFFEE_BEAN(15),
        DISPOSABLE_CUP(1)
}

enum class Espresso(val value: Int) {
        WATER(250),
        COFFEE_BEAN(16),
        DISPOSABLE_CUP(1),
        COST(4)
}

enum class Latte(val value: Int) {
        WATER(350),
        MILK(75),
        COFFEE_BEAN(20),
        DISPOSABLE_CUP(1),
        COST(7)
}

enum class Cappuccino(val value: Int) {
        WATER(200),
        MILK(100),
        COFFEE_BEAN(12),
        DISPOSABLE_CUP(1),
        COST(6)
}


