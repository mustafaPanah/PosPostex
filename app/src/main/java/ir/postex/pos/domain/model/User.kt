package ir.postex.pos.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "phone")
    val phone: String?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "password")
    val password: String?,

    @Json(name = "updated_at")
    val updatedAt: String?,

    @Json(name = "created_at")
    val createdAt: String?,

    @Json(name = "id")
    val id: Int?
)
