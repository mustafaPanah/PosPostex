package ir.postex.pos.presentation.config

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.persianswitch.smartpos.webservice.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.postex.pos.data.source.local.DataStoreConstants.ACCESS_TOKEN
import ir.postex.pos.data.source.local.DataStoreConstants.DEVICE_ID
import ir.postex.pos.data.source.local.DataStoreConstants.IS_DEVICE_CONFIGURED
import ir.postex.pos.data.source.local.DataStoreConstants.MERCHANT_ID
import ir.postex.pos.data.source.local.DataStoreConstants.SERIAL
import ir.postex.pos.data.source.local.DataStoreConstants.TERMINAL_ID

import ir.postex.pos.data.source.local.DataStoreManager
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.VerifyOtpResponse
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.domain.model.pos.PosConfigResult
import ir.postex.pos.domain.model.pos.PosSettingsResponse
import ir.postex.pos.domain.repositories.AuthRepository
import ir.postex.pos.presentation.main.MainActivity
import ir.postex.pos.security.Ed25519KeyManager
import ir.postex.pos.security.PrivateKeyStorage
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import timber.log.Timber
import java.security.KeyPair
import javax.inject.Inject


@HiltViewModel
class ConfigViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val dataStoreManager: DataStoreManager,
    private val privateKeyStorage: PrivateKeyStorage
) : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set
    private var _configState = MutableStateFlow<Resource<PosConfigResult>?>(null)
    val configState: StateFlow<Resource<PosConfigResult>?> = _configState
    private var _state = MutableStateFlow<Resource<EnrollResponse>?>(null)
    val state: StateFlow<Resource<EnrollResponse>?> = _state

    // State
    private val _terminalId = MutableStateFlow("")
    val terminalId = _terminalId.asStateFlow()

    private val _merchantId = MutableStateFlow("")
    val merchantId = _merchantId.asStateFlow()
    private val _masterKey = MutableStateFlow("")
    val masterKey = _masterKey.asStateFlow()

    private val _serial = MutableStateFlow("")
    val serial = _serial.asStateFlow()


    // Actions
    fun onTerminalChanged(value: String) {
        _terminalId.value = value
    }

    fun onMerchantChanged(value: String) {
        _merchantId.value = value
    }

    fun onMasterChanged(value: String) {
        _masterKey.value = value
    }

    fun onSerialChanged(value: String) {
        _serial.value = value
    }

    fun onConfigClick(activity: MainActivity) = viewModelScope.launch {

        _configState.value = Resource.Loading() // شروع فرآیند

        try {
            // 1️⃣ بررسی PrivateKey
            val keyPair = privateKeyStorage.loadKeyPair() ?: run {
                // ایجاد جفت کلید جدید و ذخیره
                val newKeyPair = Ed25519KeyManager.generateKeyPair()
                privateKeyStorage.saveKeyPair(newKeyPair)
                newKeyPair
            }

            // ارسال PublicKey به سرور
            val publicKeyBase64 = Ed25519KeyManager.publicKeyToBase64(keyPair.public)
            authRepository.enroll(
                publicKeyBase64,
                _terminalId.value.toInt(),
                _merchantId.value.toInt(),
                _masterKey.value,
                _serial.value
            ).collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = result
                        dataStoreManager.updateData(TERMINAL_ID, _terminalId.value)
                        dataStoreManager.updateData(MERCHANT_ID, _merchantId.value)
                        dataStoreManager.updateData(DEVICE_ID, result.data!!.deviceId.toString())
                        dataStoreManager.updateData(IS_DEVICE_CONFIGURED, true)
                        dataStoreManager.updateData(SERIAL, _serial.value)
                    }

                    is Resource.Error -> {
                        _state.value = result
                        dataStoreManager.updateData(IS_DEVICE_CONFIGURED, false)
                    }

                    is Resource.Loading -> {
                        _state.value = result
                    }
                }
            }
            delay(100)
            val serial = dataStoreManager.getData(SERIAL).first()
            val isConfigured = dataStoreManager.getData(IS_DEVICE_CONFIGURED).first()

            Timber.tag("SSSSSSSSS").e("SERIAL Value: $serial")
            Timber.tag("SSSSSSSSS").e("IS_DEVICE_CONFIGURED Value: $isConfigured")

            // 3️⃣ PublicKey Base64

            // 4️⃣ تماس با سرور برای enroll


//            if (enrollResponse is Resource.Error) {
//                _configState.value = Resource.Error(
//                    PosConfigResult(null, null, enrollResponse.message ?: "خطا در ثبت دستگاه")
//                )
//                return@launch
//            }

            // 5️⃣ صدا زدن POS Settings
//            suspendCancellableCoroutine<PosSettingsResponse> { cont ->
//                activity.launchSettings { settings ->
//                    cont.resume(settings) {}
//                }
//            }.let { settingsResponse ->
//                _configState.value = Resource.Success(
//                    PosConfigResult(
//                        enrollResponse = (enrollResponse as? Resource.Success)?.data,
//                        settingsResponse = settingsResponse
//                    )
//                )
//            }

        } catch (e: Exception) {
            Timber.e(e, "Config failed")
//            _configState.value = Resource.Error(
//                PosConfigResult(null, null, "خطا در پیکربندی دستگاه")
//            )
        }
    }
}