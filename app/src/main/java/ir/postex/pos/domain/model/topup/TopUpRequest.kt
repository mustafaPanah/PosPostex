package ir.postex.pos.domain.model.topup

data class TopUpRequest(
    val amount: Int,
    val stan: Int,
    val rrn: String,
    val transactionDate: String,
    val timestamp: Long,
)

