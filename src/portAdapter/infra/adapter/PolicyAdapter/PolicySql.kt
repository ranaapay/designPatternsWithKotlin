package portAdapter.infra.adapter.PolicyAdapter

import portAdapter.domain.port.PolicyPort
import portAdapter.domain.port.request.CreatePolicyRequest
import portAdapter.domain.port.response.GetPolicyResponse
import java.math.BigDecimal

class PolicySql : PolicyPort {
    fun connectToSql() {

    }
    override suspend fun createPolicy(createRequest: CreatePolicyRequest): String {
        //write sql db to  policy
        return ""
    }

    override suspend fun getPolicy(id: String): GetPolicyResponse {
        //get from sql db
        return GetPolicyResponse("", BigDecimal(0), BigDecimal(0))
    }
}