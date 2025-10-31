package ir.postex.pos.presentation.reportScreen

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.postex.pos.presentation.main.navigation.NavigationRoutes

@Composable
fun ReportScreen(
    navController: NavController
) {
    val transactions = listOf(
        TransactionItem(
            amount = "۴۵۰,۰۰۰",
            dateTime = "۱۴۰۳/۰۷/۲۸ - ۱۴:۲۵",
            tracking = "TRX-983472",
            isSuccess = true
        ),
        TransactionItem(
            amount = "۸۰۰,۰۰۰",
            dateTime = "۱۴۰۳/۰۷/۲۸ - ۱۲:۴۰",
            tracking = "TRX-983471",
            isSuccess = true
        ),
        TransactionItem(
            amount = "۲۵۰,۰۰۰",
            dateTime = "۱۴۰۳/۰۷/۲۸ - ۱۱:۰۲",
            tracking = "TRX-983470",
            isSuccess = false
        ),
        TransactionItem(
            amount = "۱,۲۰۰,۰۰۰",
            dateTime = "۱۴۰۳/۰۷/۲۷ - ۱۸:۴۵",
            tracking = "TRX-983469",
            isSuccess = true
        ),
        TransactionItem(
            amount = "۹۵۰,۰۰۰",
            dateTime = "۱۴۰۳/۰۷/۲۷ - ۱۷:۲۰",
            tracking = "TRX-983468",
            isSuccess = true
        ),
        TransactionItem(
            amount = "۴۰۰,۰۰۰",
            dateTime = "۱۴۰۳/۰۷/۲۷ - ۱۰:۳۰",
            tracking = "TRX-983467",
            isSuccess = false
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {

        // 🔙 نوار بالایی
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(Icons.Default.ArrowBack, contentDescription = "بازگشت")
            }

            Text(
                text = "گزارش‌گیری",
                modifier = Modifier.weight(1f),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            // فیلتر تاریخ (نمونه: امروز)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFF5F5F5))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text("امروز", color = Color.Black, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 🧾 آمار بالا
        // StatsGrid()
        val stats = listOf(
            Triple("۴۸,۰۰۰,۰۰۰", "مبلغ سفارش امروز (تومان)", Color(0xFFDCEEFF)),
            Triple("۱۲۰", "تعداد سفارش امروز", Color(0xFFE8EAF6)),
            Triple("۲", "تراکنش ناموفق امروز", Color(0xFFFFEBEE)),
            Triple("۱۱۸", "تراکنش موفق امروز", Color(0xFFE8F5E9))
        )
        Row {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StatCard(stats[0].first, stats[0].second, stats[0].third)
                Spacer(modifier = Modifier.height(4.dp))
                StatCard(stats[1].first, stats[1].second, stats[1].third)
            }
            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StatCard(stats[2].first, stats[2].second, stats[2].third)
                Spacer(modifier = Modifier.height(4.dp))
                StatCard(stats[3].first, stats[3].second, stats[3].third)
            }

        }

        Spacer(modifier = Modifier.height(12.dp))

        // 🔍 دکمه مشاهده جزئیات
        OutlinedButton(
            onClick = {navController.navigate(NavigationRoutes.FilterScreen)},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color(0xFF2196F3)),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF2196F3))
        ) {
            Text("مشاهده جزئیات", fontSize = 15.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            modifier = Modifier.fillMaxWidth()
            ,
            textAlign = TextAlign.End,
            text = "تراکنش‌ها",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 💳 لیست تراکنش‌ها
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(transactions) { tx ->
                TransactionCard(tx)
            }
        }
    }
}

@Composable
fun StatsGrid() {
    val stats = listOf(
        Triple("۴۸,۰۰۰,۰۰۰", "مبلغ سفارش امروز (تومان)", Color(0xFFDCEEFF)),
        Triple("۱۲۰", "تعداد سفارش امروز", Color(0xFFE8EAF6)),
        Triple("۲", "تراکنش ناموفق امروز", Color(0xFFFFEBEE)),
        Triple("۱۱۸", "تراکنش موفق امروز", Color(0xFFE8F5E9))
    )

    Column {
        for (row in stats.chunked(2)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { (value, label, bg) ->
                    StatCard(value, label, bg)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun StatCard(value: String, label: String, bgColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                value, fontWeight = FontWeight.Bold, fontSize = 18.sp, maxLines = 1,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                label,
                color = Color.Gray,
                fontSize = 12.sp,
                maxLines = 1,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

data class TransactionItem(
    val amount: String,
    val dateTime: String,
    val tracking: String,
    val isSuccess: Boolean
)

@Composable
fun TransactionCard(item: TransactionItem) {
    val amountColor = if (item.isSuccess) Color(0xFF2E7D32) else Color(0xFFD32F2F)

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "${if (item.isSuccess) "+" else "-"} ${item.amount}",
                    color = amountColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "مبلغ(تومان)",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.dateTime,

                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "تاریخ تراکنش",
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.tracking,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "شماره پیگیری",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "مشاهده",
                    color = Color(0xFF2196F3),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(

                    text = "جزییات",
                    fontSize = 16.sp
                )

            }

        }
    }
}
