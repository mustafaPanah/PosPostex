package ir.postex.pos.data.source.remote.network.presentation

import ir.postex.pos.domain.model.NetworkError
import ir.postex.pos.domain.model.ResourceE
import ir.postex.pos.domain.model.onError
import ir.postex.pos.domain.model.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DataLoadingViewModelDelegateImpl : DataLoadingViewModelDelegate {
    private val _dataLoadingState = MutableStateFlow<LoadDataState>(LoadDataState.Initial)
    override val dataLoadingState = _dataLoadingState.asStateFlow()

    override suspend fun <T> loadData(call: () -> ResourceE<T, NetworkError>) {
        _dataLoadingState.emit(LoadDataState.Loading)
        call.invoke().onSuccess {
            _dataLoadingState.emit(LoadDataState.Success(it))
        }.onError { error ->
            if (error == NetworkError.UNAUTHORIZED) {
                _dataLoadingState.emit(LoadDataState.Unauthorized)
            } else {
                _dataLoadingState.emit(LoadDataState.Error(error.toUiText()))
            }
        }
    }
}