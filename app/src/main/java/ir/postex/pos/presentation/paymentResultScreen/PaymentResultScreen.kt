package ir.postex.pos.presentation.paymentResultScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.postex.pos.R
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.theme.MainPrimary
import ir.postex.pos.utils.PriceFormatter

@Composable
fun PaymentResultScreen(
    isSuccess: Boolean,          // بولین تعیین‌کننده نوع نتیجه
    amount: String,
    trackingNumber: String,
    dateTime: String,
    navController:NavController
) {
    val iconRes = if (isSuccess) R.drawable.ic_success else R.drawable.ic_error
    val title = if (isSuccess) "پرداخت موفق!" else "پرداخت ناموفق!"
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            // آیکون موفق / ناموفق
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(140.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(32.dp))

            // کارت اطلاعات تراکنش
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TransactionRow(label = "مبلغ (تومان)", value = PriceFormatter.format(amount.substring(0,amount.length-1)))
                    TransactionRow(label = "شماره پیگیری", value = trackingNumber)
                    TransactionRow(label = "تاریخ تراکنش", value = dateTime)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    navController.navigate(NavigationRoutes.HomeScreen) {
                        popUpTo(NavigationRoutes.HomeScreen) {
                            inclusive = true  // یعنی HomeScreen جدید ساخته بشه و قبلی‌ها حذف شن
                        }
                        launchSingleTop = true  // از ساخت چندباره جلوگیری می‌کنه
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,       // پس‌زمینه سفید
                    contentColor = MainPrimary    // رنگ متن آبی
                ),
                border = BorderStroke(1.dp, MainPrimary), // دور آبی
                elevation = ButtonDefaults.buttonElevation(0.dp)
            ) {
                Text(
                    text = "بازگشت به خانه",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TransactionRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = Color.Gray, fontSize = 20.sp)
        Text(text = value, fontWeight = FontWeight.Medium, fontSize = 20.sp)
    }
}
