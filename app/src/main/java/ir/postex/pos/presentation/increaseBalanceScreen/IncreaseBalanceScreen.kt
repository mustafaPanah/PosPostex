package ir.postex.pos.presentation.increaseBalanceScreen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.co.legalo.presentation.loading.LoadingDialog
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.domain.model.pos.PosResponse
import ir.postex.pos.domain.model.topup.TopUpRequest
import ir.postex.pos.domain.model.topup.TopUpResponse
import ir.postex.pos.presentation.home.HomeViewModel
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.theme.IranSans
import ir.postex.pos.presentation.theme.MainPrimary
import ir.postex.pos.presentation.widget.UiDefaults
import ir.postex.pos.utils.CalendarTool
import ir.postex.pos.utils.PriceVisualTransformation
import timber.log.Timber

@Composable
fun IncreaseBalanceScreen(
    navController: NavController,
    onLaunchPos: (amount: String, onResult: (PosResponse) -> Unit) -> Unit
) {
    var customAmount by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var posResult by remember { mutableStateOf<PosResponse?>(null) }
    val viewModel: IncreaseBalanceViewModel = hiltViewModel()
    val uiState by viewModel.stateTopUp.collectAsState()
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    val context = LocalContext.current
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        LaunchedEffect(uiState) {
            if(uiState != null){
                when(uiState){
                    is Resource.Success<TopUpResponse> -> {
                        navController.navigate(NavigationRoutes.PaymentResultScreen(posResult!!.status,posResult!!.amount!!,posResult!!.rrn!!,posResult!!.time+" "+posResult!!.date))
                        isLoading = false

                    }
                    is Resource.Error<TopUpResponse> -> {
                        errorMessage = (uiState as Resource.Error<TopUpResponse>).message ?: "خطا در برقراری ارتباط"
                        Toast.makeText(
                            context,
                            errorMessage,
                            Toast.LENGTH_SHORT
                        ).show()
                        isLoading = false
                    }
                    is Resource.Loading<TopUpResponse> -> {
                        isLoading = true
                    }
                    else -> {}
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()   // ← دکمه بالای کیبورد می‌آید
        ) {
            LoadingDialog(show = isLoading)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .padding(bottom = 24.dp)
            ) {

                // 🔙 دکمه بازگشت
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.align(Alignment.End) // آیکون سمت راست
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, // 👈 آیکون فلش به سمت چپ
                        contentDescription = "بازگشت",
                        tint = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 🧾 عنوان و توضیح
                Text(
                    text = "افزایش موجودی",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "مبلغ مورد نظر جهت افزایش موجودی را وارد نمایید",
                    fontSize = 18.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                // 🔢 TextField برای مبلغ
                OutlinedTextField(
                    value = customAmount,
                   // onValueChange = { customAmount = it },
                    onValueChange = { value ->
                        val clean = value.text.filter { it.isDigit() }
                        customAmount = value.copy(
                            text = clean,
                            selection = TextRange(clean.length)
                        )
                    },
                    visualTransformation = PriceVisualTransformation(),
                    placeholder = { Text("مبلغ مورد نظر(ریال)") },
                    label = { Text("مبلغ مورد نظر(ریال)", fontSize = 18.sp) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(UiDefaults.Height),
                    shape = RoundedCornerShape(UiDefaults.Radius),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MainPrimary,
                        unfocusedBorderColor = Color(0xFFB3E5FC),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        cursorColor = MainPrimary
                    ),
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                // 💰 گزینه‌های پیش‌فرض مبالغ
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    listOf("200,000", "400,000", "800,000").forEach { amount ->
                        OutlinedButton(
                            onClick = {
                                val value = amount.replace(",", "")
                                customAmount = TextFieldValue(
                                    text = value,
                                    selection = TextRange(value.length)
                                )
                            },
                            border = BorderStroke(1.dp, MainPrimary),
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = MainPrimary
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 2.dp)
                        ) {
                            Text(
                                text = amount,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {

                       // val amount = customAmount.ifBlank { "0" } // منطق انتخاب مبلغ
                        val amount = customAmount.text.ifBlank { "0" }
                        onLaunchPos(amount) { resp ->
                            // وقتی پاسخ بازگشت، اینجا state آپدیت میشود و UI رفرش میشود
                            posResult = resp
                            if (resp.status) {
                                viewModel.topUP(
                                    TopUpRequest(
                                        resp.amount!!.toInt(),
                                        resp.stan!!.toInt(),
                                        resp.rrn!!,
                                        CalendarTool.getCurrentIsoDateTime(),
                                        CalendarTool.getCurrentTimestamp(),

                                    )
                                )
                            }
                        }
                    },
                      //  navController.navigate(NavigationRoutes.PaymentResultScreen) },
                    enabled = customAmount.text.isNotBlank(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(UiDefaults.Height),
                    shape = RoundedCornerShape(UiDefaults.Radius),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (customAmount.text.isNotBlank()) MainPrimary else Color(
                            0xFFE0E0E0
                        ),
                        contentColor = Color.White,
                        disabledContentColor = Color.Gray
                    )
                ) {
                    Text(
                        text = "تأیید", fontSize = 16.sp,
                        fontFamily = IranSans
                    )
                }
                Spacer(Modifier.height(8.dp))

                if (errorMessage.isNotEmpty()) {
                    Text(text = errorMessage, color = Color.Red, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                }
                posResult?.let { r ->
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "وضعیت: ${if (r.status) "موفق" else "ناموفق"}")
                    Text(text = "مبلغ: ${r.amount ?: "-"}")
                    Text(text = "RRN: ${r.rrn ?: "-"}")
                    Text(text = "STAN: ${r.stan ?: "-"}")
                    Text(text = "پاسخ سوئیچ: ${r.response ?: "-"}")
                  //  if(r.status)
                  //  viewModel.topUP(TopUpRequest(r.amount!!.toInt(),r.stan!!.toInt(),r.rrn!!,"2026-02-10T08:07:21.216Z",1739174841216))
                }

            }
        }
    }
}
