package com.persianswitch.smartpos.webservice


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ValueAddedRequirements(
    @Json(name = "drop_off")
    val dropOff: Boolean?,
    @Json(name = "engineering_fee")
    val engineeringFee: Boolean?,
    @Json(name = "insurance")
    val insurance: Boolean?,
    @Json(name = "logo")
    val logo: Boolean?,
    @Json(name = "packaging")
    val packaging: Boolean?,
    @Json(name = "print")
    val print: Boolean?,
    @Json(name = "register")
    val register: Boolean?,
    @Json(name = "sms")
    val sms: Boolean?
)