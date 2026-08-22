package ir.postex.pos.domain.model.pos

data class PosSettingsResponse(
    val version: String?,
    val firmware: String?,
    val terminal: String?,
    val merchant: String?,
    val name: String?
)
