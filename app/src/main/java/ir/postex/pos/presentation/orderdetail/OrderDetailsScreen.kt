package ir.postex.pos.presentation.orderdetail


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.domain.model.inquiry.InquiryResponse
import ir.postex.pos.domain.model.pos.PosResponse
import ir.postex.pos.domain.model.shipment.ShipmentPayRequest
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.theme.IranSans
import ir.postex.pos.presentation.theme.MainPrimary
import ir.postex.pos.utils.PriceFormatter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import timber.log.Timber

@Composable
fun OrderDetailsScreen(
    navController: NavHostController?,
    parcelNo:String,
    inquiryData: InquiryResponse?,
    onLaunchPos: (amount: String, onResult: (PosResponse) -> Unit) -> Unit
) {


    val viewModel: OrderDetailsViewModel = hiltViewModel()
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    val amountState by viewModel.stateGetAmuont.collectAsState()
    var posResult by remember { mutableStateOf<PosResponse?>(null) }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        LaunchedEffect(amountState) {
            if (amountState != null) {
                when (amountState) {
                    is Resource.Success<EnrollResponse> -> {
                        navController?.navigate(NavigationRoutes.PaymentResultScreen(posResult!!.status,posResult!!.amount!!,posResult!!.rrn!!,posResult!!.time+" "+posResult!!.date))
                    }

                    is Resource.Error<EnrollResponse> -> {
                        errorMessage = (amountState as Resource.Error<EnrollResponse>).message
                            ?: "خطا در برقراری ارتباط"

                        isLoading = false
                    }

                    is Resource.Loading<EnrollResponse> -> {
                        isLoading = true
                    }

                    else -> {}
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            // 🔙 آیکون بازگشت
            IconButton(
                onClick = { navController?.popBackStack() },
                modifier = Modifier.align(Alignment.End)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "بازگشت",
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 🧾 عنوان صفحه
            Text(
                text = "جزئیات سفارش",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center,
                fontFamily = IranSans
            )

            // 🧩 کارت جزئیات
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DetailRow(title = "کد رهگیری", value = inquiryData?.trackingNo.toString())
                    DetailRow(title = "نام و نام خانوادگی", value = inquiryData?.receiver?.name!!)
                    DetailRow(
                        title = "مبلغ قابل پرداخت(تومان)",
                        value = PriceFormatter.format(inquiryData.totalPayableAmount.toString().substring(0,inquiryData.totalPayableAmount.toString().length-1))
                    )
//                    repeat(8) {
//                        DetailRow(title = "میلاد برزگر", value = "میلاد برزگر")
//                    }
                }
            }
            posResult?.let { r ->
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "وضعیت: ${if (r.status) "موفق" else "ناموفق"}")
                Text(text = "مبلغ: ${r.amount ?: "-"}")
                Text(text = "RRN: ${r.rrn ?: "-"}")
                Text(text = "STAN: ${r.stan ?: "-"}")
                Text(text = "پاسخ سوئیچ: ${r.response ?: "-"}")
//                if (r.status)
//                    navController?.navigate(
//                        NavigationRoutes.PaymentResultScreen(
//                            r.status,
//                            r.amount!!,
//                            r.rrn!!,
//                            r.time!!
//                        )
//                    )

            }
            Spacer(modifier = Modifier.weight(1f))
            // 🔘 دکمه تأیید و ادامه
            Button(
                onClick = {
                 //   navController?.navigate(NavigationRoutes.PaymentResultScreen(false,"1000","0","0"))
                    onLaunchPos(inquiryData?.totalPayableAmount.toString()) { resp ->
                        // وقتی پاسخ بازگشت، اینجا state آپدیت میشود و UI رفرش میشود
                        posResult = resp

                        if (resp.status) {
                            resp.amount?.toLong()
                                ?.let { resp.rrn?.let { it1 ->
                                    resp.stan?.let { it2 ->
                                        viewModel.postShipmentPay(parcelNo, ShipmentPayRequest(
                                            it.toInt(),
                                            it1, it2, 0L, 0L
                                        ))
                                    }
                                } }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainPrimary,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "تأیید و ادامه",
                    fontSize = 16.sp,
                    fontFamily = IranSans
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun DetailRow(title: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.Gray,
            fontFamily = IranSans
        )
        Text(
            text = value,
            fontSize = 14.sp,
            color = Color.Black,

            )

    }
}
