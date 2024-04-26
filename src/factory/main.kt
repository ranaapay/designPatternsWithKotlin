package factory

fun main() {
    var budget = 10000L
    println("Welcome to the My EComm Website")
    println()
    println("You have 10k lira.")
    println()

    println("Listing products that you can buy...")
    val productDb = ProductDB()
    productDb.printProducts()

    println()
    println("Write the id of what you want to buy")
    val id = readlnOrNull()
    val buyingProduct = productDb.getProductById(id!!)
    budget -= buyingProduct.price
    println("You have left $budget lira.")

    println("You can buy extra service if bought product have financial service. See them? [y,n]")
    val answer = readlnOrNull()
    if (answer == "n") return

    val financialServiceFactory = FinancialServiceFactory()
    val financialServices = buyingProduct.eligibleServices.map { financialServiceFactory.createFinancialService(it) }
    if (financialServices.isEmpty()) println("There is no eligible financial service")

    financialServices.forEach { it!!.getOffers() }

    println("Do you want to buy financial service? [y, n]")

}


class FinancialServiceFactory {
    fun createFinancialService(type: String): FinancialService? {
        return when (type) {
            "extended" -> ExtendedWarrantyInsurance()
            "furniture" -> FurnitureMontage()
            "content" -> ContentInsurance()
            "tyre" -> TyreMontage()
            else -> null
        }
    }
}

abstract class FinancialService {
    open val price: Long = 0
    abstract fun getOffers()
    abstract fun buy()
}

class ContentInsurance : FinancialService() {
    override val price: Long
        get() = 50

    override fun getOffers() {
        println("You can buy Content Insurance with $price lira.")
    }

    override fun buy() {
        TODO("Not yet implemented")
    }
}

class ExtendedWarrantyInsurance : FinancialService() {
    override val price: Long
        get() = 70

    override fun getOffers() {
        println("You can buy Extended Warranty Insurance with $price lira.")
    }

    override fun buy() {
        TODO("Not yet implemented")
    }
}

class FurnitureMontage : FinancialService() {
    override val price: Long
        get() = 80

    override fun getOffers() {
        println("You can buy Furniture Montage with $price lira.")
    }

    override fun buy() {
        TODO("Not yet implemented")
    }
}

class TyreMontage : FinancialService() {
    override val price: Long
        get() = 100

    override fun getOffers() {
        println("You can buy Tyre Montage with $price lira.")
    }

    override fun buy() {
        TODO("Not yet implemented")
    }
}

class Product(val id: String, val name: String, val price: Long, val eligibleServices: List<String>)

class ProductDB {
    private val television = Product("1", "Television", 3500, listOf("extended"))
    private val wardrobe = Product("2", "Wardrobe", 5000, listOf("furniture"))
    private val jacket = Product("3", "Jacket", 750, listOf("content"))
    private val mercedesTyre = Product("4", "MercedesTyre", 1500, listOf("tyre"))
    private val dryer = Product("5", "HairDryer", 800, listOf("extended", "content"))
    private val book = Product("6", "Book", 200, listOf())

    val products: List<Product> = listOf(television, wardrobe, jacket, mercedesTyre, dryer, book)

    fun printProducts() {
        println("-----------------------------------")
        println("--Id--|----Name-----|--------Price-------")
        for (p in products) {
            println("--" + p.id + "--|  " + p.name + "  |    " + p.price)
        }
    }

    fun getProductById(id: String): Product {
        return when (id) {
            "1" -> television
            "2" -> wardrobe
            "3" -> jacket
            "4" -> mercedesTyre
            "5" -> dryer
            "6" -> book
            else -> Product("0", "", 0, listOf())
        }
    }
}
