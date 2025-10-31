package ir.postex.pos.presentation.login

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
import ir.postex.pos.presentation.main.MainActivity
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import timber.log.Timber

// رنگ‌ها

private val Hint = Color(0xFF9AA3AF)

@Composable
fun LoginScreen(activity: MainActivity?,
                 navController: NavHostController?) {
    val viewModel: SignInViewModel = hiltViewModel()
    val uiState by viewModel.state.collectAsState()
    val context = LocalContext.current
    val phone by viewModel.mobile.collectAsState()
    val password by viewModel.password.collectAsState()
    val pwdVisible by viewModel.passwordVisible.collectAsState()

    val focus = LocalFocusManager.current
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        LaunchedEffect(uiState) {
            if(uiState != null){
                when(uiState){
                    is Resource.Success<LoginResponse> -> {
                        Timber.d("OTPResponse")
                        navController?.navigate(NavigationRoutes.HomeScreen)
                        isLoading = false
                    }
                    is Resource.Error<LoginResponse> -> {
                        errorMessage = (uiState as Resource.Error<LoginResponse>).message ?: "خطا در برقراری ارتباط"
                        Toast.makeText(
                            context,
                            errorMessage,
                            Toast.LENGTH_SHORT
                        ).show()
                        isLoading = false
                    }
                    is Resource.Loading<LoginResponse> -> {
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
                    .padding(top = 48.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(Modifier.height(24.dp))

                // لوگو (عکسی که گفتی داری)
                Image(
                    painter = painterResource(id = R.drawable.postex_blue),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )

                Spacer(Modifier.height(16.dp))
                Text(
                    text = "خوش آمدید",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "جهت ورود به دستگاه، مشخصات خود را وارد نمایید",
                    color = Hint,
                    fontSize = 14.sp
                )
                Spacer(Modifier.height(24.dp))


                OutlinedTextField(
                    value = phone,
                    onValueChange = { viewModel.onMobileChanged(it) },
                    singleLine = true,
                    label = { Text("نام کاربری") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF01A0E1),     // رنگ حین فوکوس
                        unfocusedBorderColor = Color.Gray,          // رنگ وقتی فوکوس نداره
                        disabledBorderColor = Color.LightGray,      // رنگ وقتی غیرفعاله
                        errorBorderColor = Color.Red                // رنگ در حالت خطا
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
                Spacer(Modifier.height(14.dp))

                // گذرواژه
                OutlinedTextField(
                    value = password,
                    onValueChange = { viewModel.onPasswordChanged(it) },
                    singleLine = true,
                    label = { Text("رمز عبور") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF01A0E1),     // رنگ حین فوکوس
                        unfocusedBorderColor = Color.Gray,          // رنگ وقتی فوکوس نداره
                        disabledBorderColor = Color.LightGray,      // رنگ وقتی غیرفعاله
                        errorBorderColor = Color.Red                // رنگ در حالت خطا
                    ),
                    visualTransformation = if (pwdVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                            Icon(
                                imageVector = if (pwdVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                contentDescription = null
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focus.clearFocus()
                            viewModel.onLoginClicked()
                        }
                    )
                )

                Spacer(Modifier.height(20.dp))

                // دکمه ورود
                Button(
                    onClick = {
                        isLoading=true
                        viewModel.onLoginClicked()

                              },
                    enabled = phone.isNotBlank() && password.isNotBlank(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
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
                        Text(text = "ورود", color = Color.White, fontSize = 16.sp)
                    }
                }

                if (errorMessage.isNotEmpty()) {
                    Text(text = errorMessage, color = Color.Red, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
    BackHandler {
        activity?.finish()
    }
}

@Preview(showBackground = true, locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable fun SignInScreenPreviewLight() {
    MaterialTheme {
        LoginScreen(null ,navController = null)
    }
}
