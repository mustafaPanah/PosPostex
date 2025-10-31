package com.persianswitch.smartpos.webservice


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "default_address_id")
    val defaultAddressId: Int?,
    @Json(name = "email")
    val email: String?,
    @Json(name = "first_name")
    val firstName: String?,
    @Json(name = "is_shahkar_validate")
    val isShahkarValidate: Boolean?,
    @Json(name = "last_name")
    val lastName: String?,
    @Json(name = "mobile_no")
    val mobileNo: String?,
    @Json(name = "refresh_token")
    val refreshToken: String?,
    @Json(name = "roles")
    val roles: List<String?>?,
    @Json(name = "token")
    val token: String,
    @Json(name = "username")
    val username: String?,
    @Json(name = "value_added_requirements")
    val valueAddedRequirements: ValueAddedRequirements?
)