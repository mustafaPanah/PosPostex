package ir.postex.pos.data.source.remote.network.presentation

import ir.postex.pos.utils.presentation.UiText

sealed class LoadDataState {
    data object Initial : LoadDataState()
    data object Loading : LoadDataState()
    data class Success<T>(val data: T) : LoadDataState()
    data class Error(val message: UiText) : LoadDataState()
    data object Unauthorized : LoadDataState()
}