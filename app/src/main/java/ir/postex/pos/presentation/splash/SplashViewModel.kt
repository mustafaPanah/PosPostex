package ir.postex.pos.presentation.splash


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.postex.pos.data.source.local.DataStoreConstants.ACCESS_TOKEN
import ir.postex.pos.data.source.local.DataStoreManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    private var _isLogin = MutableStateFlow<Boolean?>(null)
    val isLogin: StateFlow<Boolean?> = _isLogin

    init {
        startTimer()
    }

    private fun startTimer() {
        viewModelScope.launch {
            delay(2000) // ۲ ثانیه
            dataStoreManager.getData(ACCESS_TOKEN).collectLatest {
                _isLogin.value = !it.isNullOrEmpty()
            }
        }
    }
}