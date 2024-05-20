package decorator

abstract class PizzaDecorator(private val pizza: IPizza) : IPizza {
    abstract fun getName() : String
    override fun calculatePrice(): Double {
        return pizza.calculatePrice()
    }

    override fun getIngredients(): List<Ingredient> {
        return pizza.getIngredients()
    }

}