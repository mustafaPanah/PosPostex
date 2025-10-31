package ir.postex.pos.domain.model

enum class NetworkError : Error {
    REQUEST_TIMEOUT,
    BAD_REQUEST,
    UNAUTHORIZED,
    FORBIDDEN,
    NULL_RESPONSE,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN,
}