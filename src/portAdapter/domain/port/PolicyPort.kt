package portAdapter.domain.port

import portAdapter.domain.port.request.CreatePolicyRequest
import portAdapter.domain.port.response.GetPolicyResponse

interface PolicyPort {
    suspend fun createPolicy(createRequest: CreatePolicyRequest): String
    suspend fun getPolicy(id : String): GetPolicyResponse
}