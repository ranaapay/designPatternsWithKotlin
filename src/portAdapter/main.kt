package portAdapter

import portAdapter.domain.port.request.CreatePolicyRequest
import portAdapter.infra.adapter.PolicyAdapter.PolicyInMemory
import java.math.BigDecimal

suspend fun main() {

    val policyDB = PolicyInMemory()

    println("yapmak istediğiniz işlemi girin; /n1. CreatePolicy 2. GetPolicy")
    val input = readlnOrNull()
    when (input) {
        "1" -> policyDB.createPolicy(CreatePolicyRequest(BigDecimal.TEN))
        "2" -> policyDB.getPolicy("5")
        else -> println("geçersiz işlem")
    }
}