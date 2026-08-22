package ir.postex.pos.presentation.main

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object PosResultBus {

    private val _result = MutableSharedFlow<PosResult?>()
    val result = _result.asSharedFlow()

    suspend fun sendResult(res: PosResult?) {
        _result.emit(res)
    }
}

data class PosResult(
    val responseCode: String?,
    val rrn: String?
)