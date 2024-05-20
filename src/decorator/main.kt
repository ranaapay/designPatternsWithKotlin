package decorator

fun main() {
    val basicPizza = BasicPizza()
    val mixedPizza = Mixed(basicPizza)
    val bbqSauceAndChickenPizza = BBQSauceAndChicken(basicPizza)
    val fourCheesePizza = FourCheese(basicPizza)

    val menu1 = Menu(mixedPizza, Drink.COKE, Extras.POTATO)
    val menu2 = Menu(mixedPizza, Drink.WATER, Extras.ONIONRINGS)
    val menu3 = Menu(bbqSauceAndChickenPizza, Drink.COKE, Extras.POTATO)
    val menu4 = Menu(bbqSauceAndChickenPizza, Drink.WATER, Extras.ONIONRINGS)
    val menu5 = Menu(fourCheesePizza, Drink.COKE, Extras.POTATO)
    val menu6 = Menu(fourCheesePizza, Drink.WATER, Extras.ONIONRINGS)

    val menus = listOf(menu1, menu2, menu3, menu4, menu5, menu6)

    println("| ------- Welcome to Pizzas of Rana ------------------------------")
    println("| Menu")
    println("| ----------------------------------------------------------------")
    println("| Pizza ----------------------------------------------------------")
    println("| ----------------------------------------------------------------")
    println("| 1.Mixed")
    println("| Ingredients : " + mixedPizza.getIngredients().map { it.name })
    println("| Price : " + mixedPizza.calculatePrice())
    println("| ----------------------------------------------------------------")
    println("| 1.BBQSauceAndChicken")
    println("| Ingredients : " + bbqSauceAndChickenPizza.getIngredients().map { it.name })
    println("| Price : " + bbqSauceAndChickenPizza.calculatePrice())
    println("| ----------------------------------------------------------------")
    println("| 1.FourCheese")
    println("| Ingredients : " + fourCheesePizza.getIngredients().map { it.name })
    println("| Price : " + fourCheesePizza.calculatePrice())
    println("| ----------------------------------------------------------------")
    println("| Menus ----------------------------------------------------------")
    menus.forEach { it.listMenuItems() }
    println("| ------------------------------------------")

}