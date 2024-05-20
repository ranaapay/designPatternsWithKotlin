package decorator

class BasicPizza : IPizza {

    private val ingredients : List<Ingredient> = listOf(Ingredient("tomato sauce", 5.3), Ingredient("dough", 3.4), Ingredient("cheese", 4.3))
    override fun calculatePrice(): Double {
        return ingredients.sumOf { it.price }
    }
    override fun getIngredients(): List<Ingredient> {
        return ingredients
    }
}