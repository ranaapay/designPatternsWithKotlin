package portAdapter.domain.port.response

import java.math.BigDecimal
import java.util.Date

data class GetPolicyResponse (val id:String, val sellingPrice: BigDecimal, val usedAmount: BigDecimal)