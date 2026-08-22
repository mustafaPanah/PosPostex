package ir.postex.pos.presentation.payment

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.co.legalo.presentation.loading.LoadingDialog
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.balance.BalanceResponse
import ir.postex.pos.domain.model.inquiry.InquiryResponse
import ir.postex.pos.domain.model.pos.PosResponse
import ir.postex.pos.presentation.increaseBalanceScreen.IncreaseBalanceViewModel
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.orderdetail.OrderDetailsScreen
import ir.postex.pos.presentation.theme.IranSans
import ir.postex.pos.presentation.theme.MainPrimary
import ir.postex.pos.presentation.widget.UiDefaults
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import timber.log.Timber

@Composable
fun PaymentScreen(
    navController: NavHostController?,
    onLaunchPos: (amount: String, onResult: (PosResponse) -> Unit) -> Unit
) {

    val viewModel: PaymentViewModel = hiltViewModel()
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    val amountState by viewModel.stateGetAmuont.collectAsState()
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        var orderId by remember { mutableStateOf(TextFieldValue("")) }
        var posResult by remember { mutableStateOf<PosResponse?>(null) }

        LaunchedEffect(amountState) {
            if (amountState != null) {
                when (amountState) {
                    is Resource.Success<InquiryResponse> -> {
                        isLoading = false
                        val inquiryData = (amountState as Resource.Success).data
                        if (inquiryData != null) {
                            val jsonString = Json.encodeToString(inquiryData)
                            navController?.navigate(NavigationRoutes.OrderDetailsScreen(orderId.text,jsonString))
                            viewModel.setStateNull()
                        }
                    }

                    is Resource.Error<InquiryResponse> -> {
                        errorMessage = (amountState as Resource.Error<InquiryResponse>).message
                            ?: "خطا در برقراری ارتباط"

                        isLoading = false
                    }

                    is Resource.Loading<InquiryResponse> -> {
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
                    .padding(horizontal = 24.dp, vertical = 32.dp)
                    .padding(bottom = 32.dp)
            ) {
                // 🔙 آیکون بازگشت
                IconButton(
                    onClick = { navController?.popBackStack() },
                    modifier = Modifier.align(Alignment.End) // آیکون سمت راست
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, // 👈 آیکون فلش به سمت چپ
                        contentDescription = "بازگشت",
                        tint = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // 🧾 عنوان
                Text(
                    text = "پرداخت",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )

                // 📝 توضیح زیر عنوان
                Text(
                    text = "شناسه سفارش را وارد نمایید",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, bottom = 24.dp)
                )

                // 🧩 فیلد ورود شناسه
                val focusRequester = remember { FocusRequester() }

                OutlinedTextField(
                    value = orderId,
                    onValueChange = { newValue -> orderId = newValue },
                    singleLine = true,
                    label = { Text("شناسه پرداخت", fontSize = 18.sp) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MainPrimary,
                        unfocusedBorderColor = Color.Gray,
                        disabledBorderColor = Color.LightGray,
                        errorBorderColor = Color.Red
                    ),
                    shape = UiDefaults.CommonShape,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(UiDefaults.Height)
                        .focusRequester(focusRequester),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    )
                )

                LaunchedEffect(Unit) {
                    // بلافاصله بعد از اجرا فوکوس می‌گیرد و کیبورد باز می‌شود
                    focusRequester.requestFocus()
                }
                Spacer(Modifier.height(16.dp))
                if (errorMessage.isNotEmpty()) {
                    Text(text = errorMessage, color = Color.Red, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Spacer(Modifier.height(16.dp))
                Spacer(Modifier.weight(1f))
                // 🔘 دکمه تایید
                Button(
                    onClick = {
                     //   navController?.navigate(NavigationRoutes.PaymentResultScreen(false,"1000","0","0"))
                        viewModel.getBalance(orderId.text)

                    },
                    enabled = orderId.text.isNotBlank(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(UiDefaults.Height),
                    shape = RoundedCornerShape(UiDefaults.Radius),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (orderId.text.isNotBlank()) MainPrimary else Color(
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
                posResult?.let { r ->
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "وضعیت: ${if (r.status) "موفق" else "ناموفق"}")
                    Text(text = "مبلغ: ${r.amount ?: "-"}")
                    Text(text = "RRN: ${r.rrn ?: "-"}")
                    Text(text = "STAN: ${r.stan ?: "-"}")
                    Text(text = "پاسخ سوئیچ: ${r.response ?: "-"}")
                }
            }
        }
    }
}
