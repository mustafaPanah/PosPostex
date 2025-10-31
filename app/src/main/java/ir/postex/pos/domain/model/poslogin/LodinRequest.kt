package ir.postex.pos.domain.model.poslogin

data class LoginRequest(
    val username: String,
    val password: String,
    val app_name: String,
    val channel: String
)
