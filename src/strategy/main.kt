package strategy

fun main() {
    println("Your debt is 5000. Select your payment method;")
    println("1. Cash")
    println("2. Credit Card")
    println("3. Remittance Transfer")

    val input = readlnOrNull()
    val payStrategy = when (input) {
        "1" -> PayWithCash()
        "2" -> PayWithCreditCard()
        "3" -> PayWithRemittanceTransfer()
        else -> PayWithOthers()
    }

    val payDebt = DebtPay()
    payDebt.setPaymentMethod(payStrategy)
    val result = payDebt.pay(5000)
    println(result)
}

interface PaymentMethod {
    fun pay(debt : Int): String
}

class PayWithCash : PaymentMethod {
    override fun pay(debt : Int): String {
        return "Your $debt$ debt is paid in cash."
    }
}
class PayWithCreditCard : PaymentMethod {
    override fun pay(debt : Int): String {
        return "Your $debt$ debt is paid in credit card."
    }
}
class PayWithRemittanceTransfer : PaymentMethod {
    override fun pay(debt : Int): String {
        return "Your $debt$ debt is paid in remittance transfer."
    }
}
class PayWithOthers : PaymentMethod {
    override fun pay(debt : Int): String {
        return "There is currently no such payment method."
    }
}
class DebtPay {
    private lateinit var paymentMethod: PaymentMethod
    fun setPaymentMethod(paymentMethod: PaymentMethod) {
        this.paymentMethod = paymentMethod
    }
    fun pay(debt : Int): String {
        return paymentMethod.pay(debt)
    }
}