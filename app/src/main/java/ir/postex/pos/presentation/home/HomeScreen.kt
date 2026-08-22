package ir.postex.pos.presentation.home

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.persianswitch.smartpos.webservice.LoginResponse
import ir.co.legalo.presentation.loading.LoadingDialog
import ir.postex.pos.R
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.balance.BalanceResponse
import ir.postex.pos.presentation.login.SignInViewModel
import ir.postex.pos.presentation.main.MainActivity
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.theme.IranSans
import ir.postex.pos.utils.DateUtils
import ir.postex.pos.utils.DateUtils.getPersianWeekDayName
import ir.postex.pos.utils.DateUtils.getTodayJalaliDate
import ir.postex.pos.utils.DateUtils.gregorianToJalali
import ir.postex.pos.utils.PriceFormatter
import kotlinx.coroutines.delay
import timber.log.Timber
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

@Composable
fun HomeScreen(
    activity: MainActivity?,
    navController: NavHostController?,

    ) {
    val viewModel: HomeViewModel = hiltViewModel()
    val balanceState by viewModel.stateteGetBalance.collectAsState()
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var balance by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        LaunchedEffect(balanceState) {
            if (balanceState != null) {
                when (balanceState) {
                    is Resource.Success<BalanceResponse> -> {
                        Timber.d("OTPResponse")
                        isLoading = false
                        balance =
                            (balanceState as Resource.Success<BalanceResponse>).data!!.amount.toString()

                        balance=balance.substring(0,balance.length-1)
                    }

                    is Resource.Error<BalanceResponse> -> {
                        errorMessage = (balanceState as Resource.Error<BalanceResponse>).message
                            ?: "خطا در برقراری ارتباط"
                        Toast.makeText(
                            context,
                            errorMessage,
                            Toast.LENGTH_SHORT
                        ).show()
                        isLoading = false
                    }

                    is Resource.Loading<BalanceResponse> -> {
                        isLoading = true
                    }

                    else -> {}
                }
            }
        }
        var currentTime by remember { mutableStateOf("") }
        LaunchedEffect(Unit) {
            userName = viewModel.getUserName()
            Timber.d("Serial from DataStore: $userName")
        }
        // ✅ تغییر 2: بروزرسانی خودکار ساعت با Calendar
        LaunchedEffect(Unit) {
            while (true) {
                // دریافت زمان فعلی با Calendar ( compatible با اندروید 7)
                val calendar = Calendar.getInstance()
                val hour = calendar.get(Calendar.HOUR_OF_DAY)
                val minute = calendar.get(Calendar.MINUTE)

                // فرمت دو رقمی
                val timeString = String.format("%02d:%02d", hour, minute)
                currentTime = timeString

                delay(1000L)
            }
        }

        val calendarForDate = Calendar.getInstance()
        val (jy, jm, jd) = getTodayJalaliDate(calendarForDate) // متد جدید
        val weekDayName = getPersianWeekDayName(calendarForDate) // متد جدید
//        var currentTime by remember { mutableStateOf(LocalTime.now()) }
//
//        // بروزرسانی خودکار ساعت
//        LaunchedEffect(Unit) {
//            while (true) {
//                currentTime = LocalTime.now()
//                delay(1000L)
//            }
//        }
//
//        // گرفتن ساعت و تاریخ شمسی از کلاس DateUtils
//        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault())
//        val (jy, jm, jd) = DateUtils.getTodayJalaliDate()
//        val weekDayName = DateUtils.getPersianWeekDayName(LocalDate.now())
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()) // 👈 اضافه کردن اسکرول
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoadingDialog(show = isLoading)
                // ساعت
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = currentTime, // ✅ الان مستقیم استفاده میشه
                    fontSize =48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontFamily = IranSans,
                )

                // تاریخ
                Text(
                    text = "$weekDayName - ${gregorianToJalali(jy, jm, jd)}",
                    // text = "$weekDayName - $jy/$jm/$jd",
                    fontSize = 22.sp,
                    color = Color.Gray,
                    fontFamily = IranSans,
                    modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
                )


                Text(
                    text = userName,
                    // text = "$weekDayName - $jy/$jm/$jd",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontFamily = IranSans,
                    modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
                )

                // لیست کارت‌ها
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    HomeCardItem(
                        title = "پرداخت",
                        subtitle = "با وارد کردن شناسه، اطلاعات را مشاهده نمایید",
                        imageRes = R.drawable.pos_machine // 👈 خودت اضافه می‌کنی
                    ) {
                        navController?.navigate(NavigationRoutes.PaymentScreen)
                    }

                    HomeCardItem(
                        title = "افزایش موجودی",
                        subtitle = "موجودی ${PriceFormatter.format(balance)} تومان",
                        imageRes = R.drawable.coin // 👈 خودت اضافه می‌کنی
                    ) {
                        navController?.navigate(NavigationRoutes.IncreaseBalanceScreen)
                    }

                    HomeCardItem(
                        title = "گزارش گیری",
                        subtitle = "گزارشات مربوط به تراکنش‌ها را مشاهده نمایید",
                        imageRes = R.drawable.calculator // 👈 خودت اضافه می‌کنی
                    ) {
                        navController?.navigate(NavigationRoutes.ReportScreen)
                    }
                }

                BackHandler {
                    activity?.finish()
                }
            }
        }
    }
}

@Composable
fun HomeCardItem(
    title: String,
    subtitle: String,
    @DrawableRes imageRes: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(124.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier.size(123.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontFamily = IranSans,
                    fontWeight = FontWeight.Medium,
                    fontSize = 22.sp,
                    color = Color.Black
                )
                Text(
                    text = subtitle,
                    fontFamily = IranSans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            }


            // آیکون سمت راست

        }
    }
}

fun getTodayJalaliDate(calendar: Calendar): Triple<Int, Int, Int> {
    // اینجا باید تاریخ رو از میلادی به شمسی تبدیل کنید
    // اگه کتابخونه خاصی استفاده میکنید، باید اون رو با Calendar تطبیق بدید
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH) + 1
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // TODO: تبدیل به تاریخ شمسی
    // اگه از PersianDate استفاده میکنید:
    // val persianDate = PersianDateConverter.millisToPersianDate(calendar.timeInMillis)
    // return Triple(persianDate.year, persianDate.month, persianDate.day)

    return Triple(year, month, day) // این موقته
}

fun getPersianWeekDayName(calendar: Calendar): String {
    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    return when (dayOfWeek) {
        Calendar.SATURDAY -> "شنبه"
        Calendar.SUNDAY -> "یکشنبه"
        Calendar.MONDAY -> "دوشنبه"
        Calendar.TUESDAY -> "سه‌شنبه"
        Calendar.WEDNESDAY -> "چهارشنبه"
        Calendar.THURSDAY -> "پنج‌شنبه"
        Calendar.FRIDAY -> "جمعه"
        else -> ""
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0FF)
@Composable
fun HomeScreenPreview() {
    //  HomeScreen(modifier = Modifier, MainActivity())
}