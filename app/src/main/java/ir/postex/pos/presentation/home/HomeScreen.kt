package ir.postex.pos.presentation.home

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.postex.pos.R
import ir.postex.pos.presentation.main.MainActivity
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.theme.IranSans
import ir.postex.pos.utils.DateUtils
import kotlinx.coroutines.delay
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun HomeScreen(
    activity: MainActivity?,
    navController: NavHostController?,

    ) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        var currentTime by remember { mutableStateOf(LocalTime.now()) }

        // بروزرسانی خودکار ساعت
        LaunchedEffect(Unit) {
            while (true) {
                currentTime = LocalTime.now()
                delay(1000L)
            }
        }

        // گرفتن ساعت و تاریخ شمسی از کلاس DateUtils
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault())
        val (jy, jm, jd) = DateUtils.getTodayJalaliDate()
        val weekDayName = DateUtils.getPersianWeekDayName(LocalDate.now())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ساعت
        Text(
            modifier = Modifier.padding(top = 64.dp),
            text = currentTime.format(timeFormatter),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontFamily = IranSans, // 👈 فونت سفارشی
        )

        // تاریخ
        Text(
            text = "$weekDayName - $jy/$jm/$jd",
            fontSize = 16.sp,
            color = Color.Gray,
            fontFamily = IranSans,
            modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
        )

        // لیست کارت‌ها
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            HomeCardItem(
                title = "پرداخت",
                subtitle = "با وارد کردن شناسه، اطلاعات را مشاهده نمایید",
                imageRes = R.drawable.pos_machine // 👈 خودت اضافه می‌کنی
            ){
                navController?.navigate(NavigationRoutes.PaymentScreen)
            }

            HomeCardItem(
                title = "افزایش موجودی",
                subtitle = "موجودی: ۱۲۳,۰۰۰ تومان",
                imageRes = R.drawable.coin // 👈 خودت اضافه می‌کنی
            ){
                navController?.navigate(NavigationRoutes.IncreaseBalanceScreen)
            }

            HomeCardItem(
                title = "گزارش گیری",
                subtitle = "گزارشات مربوط به تراکنش‌ها را مشاهده نمایید",
                imageRes = R.drawable.calculator // 👈 خودت اضافه می‌کنی
            ){
                navController?.navigate(NavigationRoutes.ReportScreen)
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
                modifier = Modifier.size(86.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontFamily = IranSans,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = subtitle,
                    fontFamily = IranSans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }



            // آیکون سمت راست

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0FF)
@Composable
fun HomeScreenPreview() {
  //  HomeScreen(modifier = Modifier, MainActivity())
}