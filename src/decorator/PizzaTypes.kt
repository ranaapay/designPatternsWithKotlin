package decorator

class Mixed(pizza: IPizza) : PizzaDecorator(pizza) {
    private val name: String = "Mixed Pizza"

    private val ingredients: MutableList<Ingredient> = mutableListOf(
        Ingredient("sausage", 6.0),
        Ingredient("olive", 3.0),
        Ingredient("pepper", 2.0),
        Ingredient("corn", 6.0),
        Ingredient("mushroom", 7.0),
    )

    override fun getName(): String {
        return name
    }
    override fun getIngredients(): List<Ingredient> {
        return super.getIngredients() + ingredients
    }
    override fun calculatePrice(): Double {
        return super.calculatePrice() + ingredients.sumOf { it.price }
    }
}

class BBQSauceAndChicken(pizza: IPizza) : PizzaDecorator(pizza) {
    private val name: String = "BBQSauceAndChicken Pizza"

    private val ingredients: MutableList<Ingredient> = mutableListOf(
        Ingredient("BBQSauce", 6.0),
        Ingredient("Chicken", 15.0),
    )
    override fun getIngredients(): List<Ingredient> {
        return super.getIngredients() + ingredients
    }
    override fun calculatePrice(): Double {
        return super.calculatePrice() + ingredients.sumOf { it.price }
    }
    override fun getName(): String {
        return name
    }
}

class FourCheese(pizza: IPizza) : PizzaDecorator(pizza) {
    private val name: String = "FourCheese Pizza"

    private val ingredients: MutableList<Ingredient> = mutableListOf(
        Ingredient("mozzarella cheese", 6.0),
        Ingredient("feta cheese", 7.0),
        Ingredient("parmesan cheese", 10.0),
        Ingredient("sesame seeds", 5.0),
    )

    override fun getIngredients(): List<Ingredient> {
        return super.getIngredients() + ingredients
    }
    override fun calculatePrice(): Double {
        return super.calculatePrice() + ingredients.sumOf { it.price }
    }
    override fun getName(): String {
        return name
    }
}