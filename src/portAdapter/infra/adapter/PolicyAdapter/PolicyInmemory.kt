package portAdapter.infra.adapter.PolicyAdapter

import portAdapter.domain.model.Policy
import portAdapter.domain.port.PolicyPort
import portAdapter.domain.port.request.CreatePolicyRequest
import portAdapter.domain.port.response.GetPolicyResponse
import java.math.BigDecimal
import java.time.LocalDate

class PolicyInMemory : PolicyPort {
    private var policies: MutableList<Policy> = mutableListOf()

    override suspend fun createPolicy(createRequest: CreatePolicyRequest): String {
        val lastPolicyId = policies.last().id
        val policy =
            Policy(lastPolicyId + 1, LocalDate.now(), createRequest.sellingPrice, BigDecimal(100), LocalDate.now())
        policies.add(policy)
        return policy.id
    }

    override suspend fun getPolicy(id: String): GetPolicyResponse {
        val policy = policies.find { it.id == id }
        if (policy == null) return GetPolicyResponse("", BigDecimal(0), BigDecimal(0))
        return GetPolicyResponse(policy.id, policy.sellingPrice, policy.usedAmount)
    }
}