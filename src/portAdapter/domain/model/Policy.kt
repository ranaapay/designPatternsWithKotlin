package portAdapter.domain.model

import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class Policy(val id: String, val startDate: LocalDate, val sellingPrice: BigDecimal, val usedAmount: BigDecimal, val updatedAt: LocalDate)