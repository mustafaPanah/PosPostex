package ir.postex.pos.domain.model

typealias DomainError = Error

sealed interface ResourceE<out D, out E : Error> {
    data class Success<out D>(val data: D) : ResourceE<D, Nothing>
    data class Error<out E : DomainError>(val error: E) : ResourceE<Nothing, E>
}

inline fun <T, E : Error, R> ResourceE<T, E>.map(map: (T) -> R): ResourceE<R, E> {
    return when (this) {
        is ResourceE.Error -> ResourceE.Error(error)
        is ResourceE.Success -> ResourceE.Success(map(data))
    }
}

inline fun <T, E : Error> ResourceE<T, E>.onSuccess(action: (T) -> Unit): ResourceE<T, E> {
    return when (this) {
        is ResourceE.Error -> this

        is ResourceE.Success -> {
            action(data)
            this
        }
    }
}

inline fun <T, E : Error> ResourceE<T, E>.onError(action: (E) -> Unit): ResourceE<T, E> {
    return when (this) {
        is ResourceE.Error -> {
            action(error)
            this
        }

        is ResourceE.Success -> this
    }
}