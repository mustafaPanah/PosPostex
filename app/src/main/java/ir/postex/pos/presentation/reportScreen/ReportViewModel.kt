package ir.postex.pos.presentation.reportScreen

import android.util.Base64
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.postex.pos.data.source.local.DataStoreConstants.DEVICE_ID
import ir.postex.pos.data.source.local.DataStoreConstants.MERCHANT_ID
import ir.postex.pos.data.source.local.DataStoreConstants.TERMINAL_ID
import ir.postex.pos.data.source.local.DataStoreManager
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.balance.BalanceResponse
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.domain.model.inquiry.InquiryResponse
import ir.postex.pos.domain.model.report.DailyReportItem
import ir.postex.pos.domain.model.report.DailyReportResponse
import ir.postex.pos.domain.model.report.TransactionsItem
import ir.postex.pos.domain.model.topup.TopUpRequest
import ir.postex.pos.domain.repositories.MainRepository
import ir.postex.pos.security.Ed25519KeyManager
import ir.postex.pos.security.PrivateKeyStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import java.security.MessageDigest
import java.security.PrivateKey
import java.security.Signature
import javax.inject.Inject

@HiltViewModel
class ReportViewModel @Inject constructor(
    private val repository: MainRepository,
    private val dataStoreManager: DataStoreManager,
    private val privateKeyStorage: PrivateKeyStorage
) : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set

    private var _stateGetDailyReport = MutableStateFlow<Resource<List<DailyReportItem>>?>(null)
    val stateGetDailyReport: StateFlow<Resource<List<DailyReportItem>>?> = _stateGetDailyReport

    private var _stateGetTransactions = MutableStateFlow<Resource<List<TransactionsItem>>?>(null)
    val stateGetTransactions: StateFlow<Resource<List<TransactionsItem>>?> = _stateGetTransactions


    init {
        viewModelScope.launch {
            dataStoreManager.updateData(TERMINAL_ID, "12345")

            // جمع‌آوری مقادیر Flow
            dataStoreManager.getData(DEVICE_ID).collect { deviceId ->
                Timber.tag("aaaaa").e("DEVICE_ID: $deviceId")
            }

            dataStoreManager.getData(MERCHANT_ID).collect { merchantId ->
                Timber.tag("aaaaa").e("MERCHANT_ID: $merchantId")
            }

            dataStoreManager.getData(TERMINAL_ID).collect { terminalId ->
                Timber.tag("aaaaa").e("TERMINAL_ID: $terminalId")
            }
        }

        getDailyReport()
    }

    private fun getDailyReport() = viewModelScope.launch {

        repository.getDailyReport().collectLatest { result ->
            when (result) {
                is Resource.Success -> {
                    _stateGetDailyReport.value = result

                }

                is Resource.Error -> {
                    _stateGetDailyReport.value = result
                }

                is Resource.Loading -> {
                    _stateGetDailyReport.value = result
                }
            }
        }
    }

     fun getTransactions(fromDate:String,toDate:String) = viewModelScope.launch {

        repository.getTransactions(fromDate,toDate).collectLatest { result ->
            when (result) {
                is Resource.Success -> {
                    _stateGetTransactions.value = result

                }

                is Resource.Error -> {
                    _stateGetTransactions.value = result
                }

                is Resource.Loading -> {
                    _stateGetTransactions.value = result
                }
            }
        }
    }

    fun setStateNull() {
        _stateGetDailyReport.value = null
        _stateGetTransactions.value = null
    }
}