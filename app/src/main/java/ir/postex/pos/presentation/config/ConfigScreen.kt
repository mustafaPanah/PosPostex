package ir.postex.pos.presentation.config

import android.content.res.Configuration
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.persianswitch.smartpos.webservice.LoginResponse
import ir.co.legalo.presentation.loading.LoadingDialog
import ir.postex.pos.R
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.VerifyOtpResponse
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.presentation.login.SignInViewModel
import ir.postex.pos.presentation.main.MainActivity
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.widget.UiDefaults
import timber.log.Timber

// رنگ‌ها



@Composable
fun ConfigScreen(activity: MainActivity?,
                 navController: NavHostController?) {
    val viewModel: ConfigViewModel = hiltViewModel()
    val uiState by viewModel.state.collectAsState()
    val context = LocalContext.current
    val terminalId by viewModel.terminalId.collectAsState()
    val merchantId by viewModel.merchantId.collectAsState()
    val masterKey by viewModel.masterKey.collectAsState()
    val serial by viewModel.serial.collectAsState()

    val focus = LocalFocusManager.current
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var successMessage by remember { mutableStateOf("") }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        LaunchedEffect(uiState) {
            if(uiState != null){
                when(uiState){
                    is Resource.Success<EnrollResponse> -> {
                        Timber.d("OTPResponse")
                      //  navController?.navigate(NavigationRoutes.HomeScreen)
                        successMessage="راه اندازی با موفقیت انجام شد."
                        isLoading = false
                    }
                    is Resource.Error<EnrollResponse> -> {
                        errorMessage = (uiState as Resource.Error<EnrollResponse>).message ?: "خطا در برقراری ارتباط"
                        Toast.makeText(
                            context,
                            errorMessage,
                            Toast.LENGTH_SHORT
                        ).show()
                        isLoading = false
                    }
                    is Resource.Loading<EnrollResponse> -> {
                        isLoading = true
                    }
                    else -> {}
                }
            }
        }
        Scaffold { padding ->
            LoadingDialog(show = isLoading)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 24.dp)
                    .padding(top = 32.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = terminalId,
                    onValueChange = { viewModel.onTerminalChanged(it) },
                    singleLine = true,
                    label = { Text("شماره ترمینال", fontSize = 16.sp) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF01A0E1),     // رنگ حین فوکوس
                        unfocusedBorderColor = Color.Gray,          // رنگ وقتی فوکوس نداره
                        disabledBorderColor = Color.LightGray,      // رنگ وقتی غیرفعاله
                        errorBorderColor = Color.Red                // رنگ در حالت خطا
                    ),
                    shape = UiDefaults.CommonShape,

                    modifier = Modifier.fillMaxWidth()
                        .height(UiDefaults.Height)
                       ,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    )
                )
                Spacer(Modifier.height(12.dp))
                OutlinedTextField(
                    value = merchantId,
                    onValueChange = { viewModel.onMerchantChanged(it) },
                    singleLine = true,
                    label = { Text("شماره پذیرنده", fontSize = 16.sp) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF01A0E1),     // رنگ حین فوکوس
                        unfocusedBorderColor = Color.Gray,          // رنگ وقتی فوکوس نداره
                        disabledBorderColor = Color.LightGray,      // رنگ وقتی غیرفعاله
                        errorBorderColor = Color.Red                // رنگ در حالت خطا
                    ),
                    shape = UiDefaults.CommonShape,

                    modifier = Modifier.fillMaxWidth()
                        .height(UiDefaults.Height)
                    ,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    )
                )
                Spacer(Modifier.height(12.dp))
                OutlinedTextField(
                    value = masterKey,
                    onValueChange = { viewModel.onMasterChanged(it) },
                    singleLine = true,
                    label = { Text("رمز", fontSize = 16.sp) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF01A0E1),     // رنگ حین فوکوس
                        unfocusedBorderColor = Color.Gray,          // رنگ وقتی فوکوس نداره
                        disabledBorderColor = Color.LightGray,      // رنگ وقتی غیرفعاله
                        errorBorderColor = Color.Red                // رنگ در حالت خطا
                    ),
                    shape = UiDefaults.CommonShape,

                    modifier = Modifier.fillMaxWidth()
                        .height(UiDefaults.Height)
                    ,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    )
                )
                Spacer(Modifier.height(20.dp))
                OutlinedTextField(
                    value = serial,
                    onValueChange = { viewModel.onSerialChanged(it) },
                    singleLine = true,
                    label = { Text("سریال دستگاه", fontSize = 16.sp) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF01A0E1),     // رنگ حین فوکوس
                        unfocusedBorderColor = Color.Gray,          // رنگ وقتی فوکوس نداره
                        disabledBorderColor = Color.LightGray,      // رنگ وقتی غیرفعاله
                        errorBorderColor = Color.Red                // رنگ در حالت خطا
                    ),
                    shape = UiDefaults.CommonShape,

                    modifier = Modifier.fillMaxWidth()
                        .height(UiDefaults.Height)
                    ,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
                Spacer(Modifier.height(8.dp))
                // دکمه ورود
                Button(
                    onClick = {
                        isLoading=true
                        viewModel.onConfigClick(activity!!)

                              },
                    enabled = terminalId.isNotBlank() && merchantId.isNotBlank()&&masterKey.isNotBlank()&&serial.isNotBlank(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(UiDefaults.Height)
                       ,
                    shape = RoundedCornerShape(UiDefaults.Radius),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF01A0E1)
                    )
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    } else {
                        Text(text = "راه اندازی", color = Color.White, fontSize = 22.sp)
                    }
                }

                Spacer(Modifier.height(8.dp))

                if (errorMessage.isNotEmpty()) {
                    Text(text = errorMessage, color = Color.Red, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                }
                if (successMessage.isNotEmpty()) {
                    Text(text = successMessage, color = Color.Green, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
//    BackHandler {
//        activity?.finish()
//    }
}

@Preview(showBackground = true, locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable fun SignInScreenPreviewLight() {
    MaterialTheme {
        ConfigScreen(null ,navController = null)
    }
}
