package decorator

interface IPizza {
    fun calculatePrice() : Double
    fun getIngredients() : List<Ingredient>
}