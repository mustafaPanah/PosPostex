package ir.postex.pos.domain.model.enroll

data class EnrollRequest(
    val deviceSerialNo: String,
    val terminalId: Int,
    val merchantId: Int,
   // val userId: String,
    val publicKey: String,
    val masterKey: String,
)