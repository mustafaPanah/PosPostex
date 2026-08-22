package ir.postex.pos.domain.model.pos

data class PosResponse(
    val status: Boolean,
    val date: String?,
    val time: String?,
    val stan: String?,
    val rrn: String?,
    val response: String?,
    val guid: String?,
    val amount: String?
)
