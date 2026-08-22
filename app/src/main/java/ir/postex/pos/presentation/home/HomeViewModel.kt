package ir.postex.pos.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.postex.pos.data.source.local.DataStoreConstants.IS_DEVICE_CONFIGURED
import ir.postex.pos.data.source.local.DataStoreConstants.SERIAL
import ir.postex.pos.data.source.local.DataStoreConstants.USER_ID
import ir.postex.pos.data.source.local.DataStoreConstants.USER_ID_NET
import ir.postex.pos.data.source.local.DataStoreManager
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.balance.BalanceResponse
import ir.postex.pos.domain.repositories.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MainRepository,
    private val store:DataStoreManager
) : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set

    private var _stateGetBalance = MutableStateFlow<Resource<BalanceResponse>?>(null)
    val stateteGetBalance: StateFlow<Resource<BalanceResponse>?> = _stateGetBalance

    init {
        getBalance()


    }
    suspend fun getUserName(): String {
        Timber.tag("NNNNNNNNNN").e(store.getData(USER_ID).first() ?: "")
        return store.getData(USER_ID).first() ?: ""
    }
    fun getBalance()= viewModelScope.launch {


        kotlinx.coroutines.delay(100)
        repository.getBalance().collectLatest { result ->
            when(result){
                is Resource.Success -> {
                    _stateGetBalance.value = result

                  //  store.updateData(USER_ID,result.data?.userId.toString())
                    store.updateData(USER_ID_NET,result.data?.userId.toString())

                }
                is Resource.Error -> {
                    _stateGetBalance.value = result
                }
                is Resource.Loading -> {
                    _stateGetBalance.value = result
                }
            }
        }

    }

}