package ir.postex.pos.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.persianswitch.smartpos.webservice.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.postex.pos.data.source.local.DataStoreConstants.ACCESS_TOKEN

import ir.postex.pos.data.source.local.DataStoreManager
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.VerifyOtpResponse
import ir.postex.pos.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set

    private var _state = MutableStateFlow<Resource<LoginResponse>?>(null)
    val state: StateFlow<Resource<LoginResponse>?> = _state
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

    fun togglePasswordVisibility() { _passwordVisible.value = !_passwordVisible.value }
    fun onLoginClicked()= viewModelScope.launch {

        authRepository.login(_mobile.value,_password.value).collectLatest { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = result
                    result.data?.token?.let {
                        dataStoreManager.updateData(ACCESS_TOKEN, it)
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

}