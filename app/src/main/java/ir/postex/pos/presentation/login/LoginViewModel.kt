package ir.postex.pos.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.persianswitch.smartpos.webservice.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.postex.pos.data.source.local.DataStoreConstants.ACCESS_TOKEN
import ir.postex.pos.data.source.local.DataStoreConstants.IS_DEVICE_CONFIGURED
import ir.postex.pos.data.source.local.DataStoreConstants.REFRESH_TOKEN
import ir.postex.pos.data.source.local.DataStoreConstants.SERIAL
import ir.postex.pos.data.source.local.DataStoreConstants.USER_ID

import ir.postex.pos.data.source.local.DataStoreManager
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.domain.model.pos.PosConfigResult
import ir.postex.pos.domain.model.pos.PosSettingsResponse
import ir.postex.pos.domain.repositories.AuthRepository
import ir.postex.pos.presentation.main.MainActivity
import ir.postex.pos.security.PrivateKeyStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val dataStoreManager: DataStoreManager,
    private val privateKeyStorage: PrivateKeyStorage
) : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set
    private var _configState = MutableStateFlow<Resource<PosConfigResult>?>(null)
    val configState: StateFlow<Resource<PosConfigResult>?> = _configState
    private var _state = MutableStateFlow<Resource<LoginResponse>?>(null)
    val state: StateFlow<Resource<LoginResponse>?> = _state

    private var _isDeviceConfigured = MutableStateFlow(false)
    val isDeviceConfigured: StateFlow<Boolean> = _isDeviceConfigured.asStateFlow()

    // State
    private val _mobile = MutableStateFlow("")
    val mobile = _mobile.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _passwordVisible = MutableStateFlow(false)
    val passwordVisible = _passwordVisible.asStateFlow()

    // Actions
    fun onMobileChanged(value: String) {
        _mobile.value = value
    }

    fun onPasswordChanged(value: String) {
        _password.value = value
    }

    init {
        observeDeviceConfig()
    }

    private fun observeDeviceConfig() {


        viewModelScope.launch {

            val serial = dataStoreManager.getData(SERIAL).first()

            if (serial.isNullOrEmpty()){
                _isDeviceConfigured.value=false
                Timber.tag("TTTTTTTTTTTtt").e("IS_DEVICE_CONFIGURED value     True")
            }else{
                _isDeviceConfigured.value  =true
                Timber.tag("TTTTTTTTTTTtt").e("IS_DEVICE_CONFIGURED value     false")
            }
        }
    }

    private var _enrollState = MutableStateFlow<Resource<EnrollResponse>?>(null)
    val enrollState: StateFlow<Resource<EnrollResponse>?> = _enrollState

    fun togglePasswordVisibility() {
        _passwordVisible.value = !_passwordVisible.value
    }

    fun onLoginClicked() = viewModelScope.launch {

        authRepository.login(_mobile.value, _password.value).collectLatest { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = result
                    result.data?.token?.let {
                        dataStoreManager.updateData(ACCESS_TOKEN, it)
                    }

                    result.data?.refreshToken?.let {
                        dataStoreManager.updateData(
                            REFRESH_TOKEN,
                            it
                        )
                    }
                    val user =result.data?.firstName.toString()+" "+result.data?.lastName.toString()+"(" +result.data?.username.toString()+")"
                    dataStoreManager.updateData(USER_ID, user)
                    result.data?.firstName?.let {
                        val user =result.data.firstName.toString()+" "+result.data.lastName.toString()+"(" +result.data.username.toString()+")"
                        dataStoreManager.updateData(USER_ID, user)
                    }
                }

                is Resource.Error -> {
                    _state.value = result
                }

                is Resource.Loading -> {
                    _state.value = result
                }
            }
        }
    }

    fun onSettingClick(activity: MainActivity) = viewModelScope.launch {

        // 5️⃣ صدا زدن POS Settings
        suspendCancellableCoroutine<PosSettingsResponse> { cont ->
            activity.launchSettings { settings ->
                cont.resume(settings) {}
            }
        }.let { settingsResponse ->

        }

    }
}