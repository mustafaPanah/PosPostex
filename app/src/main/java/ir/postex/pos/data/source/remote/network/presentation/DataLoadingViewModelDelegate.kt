package ir.postex.pos.data.source.remote.network.presentation

import ir.postex.pos.domain.model.NetworkError
import ir.postex.pos.domain.model.ResourceE
import kotlinx.coroutines.flow.SharedFlow

interface DataLoadingViewModelDelegate {
    val dataLoadingState: SharedFlow<LoadDataState>
    suspend fun <T> loadData(call: () -> ResourceE<T, NetworkError>)
}