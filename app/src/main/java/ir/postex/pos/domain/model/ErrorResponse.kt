package ir.postex.pos.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    val isSuccess: Boolean? = null,
    val message: String? = null,
    val timestamp: String? = null,
    val status: Int? = null,
    val error: String? = null,
    val path: String? = null
) {
    // متد کمکی برای گرفتن پیام خطا
    fun getErrorMessage(): String {
        return when {
            // اولویت با message هست
            !message.isNullOrEmpty() -> message
            // اگه message نبود، error رو برمیگردونه
            !error.isNullOrEmpty() -> error
            // اگه هیچکدوم نبود، پیام پیش‌فرض
            else -> "An unexpected error occurred"
        }
    }
}
