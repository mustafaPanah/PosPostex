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
import androidx.navigation.NavHostController
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.theme.IranSans
import ir.postex.pos.presentation.theme.MainPrimary

@Composable
fun OrderDetailsScreen(
    navController: NavHostController?
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
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
                    DetailRow(title = "مبلغ قابل پرداخت (تومان)", value = "2000,000")
                    DetailRow(title = "نوع سفارش", value = "پس کرایه")
                    DetailRow(title = "تاریخ ثبت", value = "۱۴۰۴/۰۵/۰۱")
                    repeat(8) {
                        DetailRow(title = "میلاد برزگر", value = "میلاد برزگر")
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // 🔘 دکمه تأیید و ادامه
            Button(
                onClick = { navController?.navigate(NavigationRoutes.PaymentResultScreen) },
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
            text = value,
            fontSize = 14.sp,
            color = Color.Black,

        )
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.Gray,
            fontFamily = IranSans
        )
    }
}
