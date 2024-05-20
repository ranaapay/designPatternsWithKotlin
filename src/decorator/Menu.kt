package decorator

class Menu(private val pizza: PizzaDecorator, private val drink: Drink, private val extras: Extras){
    fun listMenuItems() {
        println("| ----------------------------------------------------------------")
        println("| 1. Mixed Menu --------------------------------------------------")
        println("| Pizza:  " + pizza.getName() + " Price: "+ pizza.calculatePrice())
        println("| Drink:  " + drink.name + " Price: "+ drink.price)
        println("| Extra:  " + extras.name + " Price: "+ extras.price)
        println("| Total Price: " + (extras.price + drink.price + pizza.calculatePrice()))
    }
}

enum class Drink(val price: Double) {
    COKE(8.0),
    WATER(5.0)
}

enum class Extras(val price: Double){
    POTATO(15.0),
    ONIONRINGS(20.0)
}