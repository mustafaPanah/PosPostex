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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.co.legalo.presentation.loading.LoadingDialog
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.inquiry.InquiryResponse
import ir.postex.pos.domain.model.report.DailyReportItem
import ir.postex.pos.domain.model.report.DailyReportResponse
import ir.postex.pos.domain.model.report.TransactionsItem
import ir.postex.pos.presentation.main.navigation.NavigationRoutes
import ir.postex.pos.presentation.payment.PaymentViewModel
import ir.postex.pos.presentation.widget.UiDefaults
import ir.postex.pos.utils.CalendarTool
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.bouncycastle.asn1.x500.style.RFC4519Style.o

@Composable
fun ReportScreen(
    navController: NavController
) {

    val viewModel: ReportViewModel = hiltViewModel()
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    val dailyReportState by viewModel.stateGetDailyReport.collectAsState()
    val transactionsState by viewModel.stateGetTransactions.collectAsState()
    var reportItems by remember { mutableStateOf<List<DailyReportItem>>(emptyList()) }
    var transactionItems by remember { mutableStateOf<List<TransactionsItem>>(emptyList()) }
    var hasFetchedTransactions by remember { mutableStateOf(false) } // پرچم جدید
//
    LaunchedEffect(dailyReportState) {
        if (dailyReportState != null) {
            when (dailyReportState) {
                is Resource.Success<List<DailyReportItem>> -> {
                    isLoading = false
                    reportItems = (dailyReportState as Resource.Success<List<DailyReportItem>>).data ?: emptyList()
                    // فقط اگر قبلاً دریافت نشده باشه
                    if (!hasFetchedTransactions) {
                        hasFetchedTransactions = true
                        viewModel.getTransactions(CalendarTool.getCurrentIsoDate(), CalendarTool.getCurrentIsoDate())
                    }
                }
                is Resource.Error<List<DailyReportItem>> -> {
                    errorMessage = (dailyReportState as Resource.Error<DailyReportResponse>).message ?: "خطا در برقراری ارتباط"
                    isLoading = false
                }
                is Resource.Loading<List<DailyReportItem>> -> {
                    isLoading = true
                }
                else -> {}
            }
        }
    }

    LaunchedEffect(transactionsState) {
        if (transactionsState != null) {
            when (transactionsState) {
                is Resource.Success<List<TransactionsItem>> -> {
                    isLoading = false
                    transactionItems = (transactionsState as Resource.Success<List<TransactionsItem>>).data ?: emptyList()
                   // viewModel.setStateNull()
                }
                is Resource.Error<List<TransactionsItem>> -> {
                    errorMessage = (transactionsState as Resource.Error<TransactionsItem>).message ?: "خطا در برقراری ارتباط"
                    isLoading = false
                }
                is Resource.Loading<List<TransactionsItem>> -> {
                    isLoading = true
                }
                else -> {}
            }
        }
    }


//    val transactionsیسی = listOf(
//        TransactionItem(
//            amount = "۴۵۰,۰۰۰",
//            dateTime = "۱۴۰۳/۰۷/۲۸ - ۱۴:۲۵",
//            tracking = "TRX-983472",
//            isSuccess = true
//        ),
//        TransactionItem(
//            amount = "۸۰۰,۰۰۰",
//            dateTime = "۱۴۰۳/۰۷/۲۸ - ۱۲:۴۰",
//            tracking = "TRX-983471",
//            isSuccess = true
//        ),
//        TransactionItem(
//            amount = "۲۵۰,۰۰۰",
//            dateTime = "۱۴۰۳/۰۷/۲۸ - ۱۱:۰۲",
//            tracking = "TRX-983470",
//            isSuccess = false
//        ),
//        TransactionItem(
//            amount = "۱,۲۰۰,۰۰۰",
//            dateTime = "۱۴۰۳/۰۷/۲۷ - ۱۸:۴۵",
//            tracking = "TRX-983469",
//            isSuccess = true
//        ),
//        TransactionItem(
//            amount = "۹۵۰,۰۰۰",
//            dateTime = "۱۴۰۳/۰۷/۲۷ - ۱۷:۲۰",
//            tracking = "TRX-983468",
//            isSuccess = true
//        ),
//        TransactionItem(
//            amount = "۴۰۰,۰۰۰",
//            dateTime = "۱۴۰۳/۰۷/۲۷ - ۱۰:۳۰",
//            tracking = "TRX-983467",
//            isSuccess = false
//        )
//    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {

        LoadingDialog(show = isLoading)
        Spacer(modifier = Modifier.height(24.dp))
        // 🔙 نوار بالایی
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {navController.popBackStack()}) {
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


        if(reportItems.isNotEmpty()) {
            val stats = listOf(
                Triple(reportItems[0].value, reportItems[0].title, Color(0xFFDCEEFF)),
                Triple(reportItems[1].value, reportItems[1].title, Color(0xFFE8EAF6)),
                Triple(reportItems[2].value, reportItems[2].title, Color(0xFFFFEBEE)),
                Triple(reportItems[3].value, reportItems[3].title, Color(0xFFE8F5E9)),
               // Triple("۱۲۰", "تعداد سفارش امروز", Color(0xFFE8EAF6)),
               // Triple("۲", "تراکنش ناموفق امروز", Color(0xFFFFEBEE)),
               // Triple("۱۱۸", "تراکنش موفق امروز", Color(0xFFE8F5E9))
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
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 🔍 دکمه مشاهده جزئیات
//        OutlinedButton(
//            onClick = { navController.navigate(NavigationRoutes.FilterScreen) },
//            modifier = Modifier.fillMaxWidth().height(UiDefaults.Height),
//            shape = RoundedCornerShape(12.dp),
//            border = BorderStroke(1.dp, Color(0xFF2196F3)),
//            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF2196F3))
//        ) {
//            Text("مشاهده جزئیات", fontSize = 15.sp)
//        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            text = "تراکنش‌ها",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 💳 لیست تراکنش‌ها
        if (transactionItems.isNotEmpty())
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(transactionItems) { tx ->
                TransactionCard(tx)
            }
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

//data class TransactionItem(
//    val amount: String,
//    val dateTime: String,
//    val tracking: String,
//    val isSuccess: Boolean
//)

@Composable
fun TransactionCard(item: TransactionsItem) {
    val amountColor = if (true) Color(0xFF2E7D32) else Color(0xFFD32F2F)

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "${if (true) "+" else "-"} ${item.amount}",
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
                    text = CalendarTool.convertIsoToPersianDateTime(item.createdAt),

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
                    text = item.stan,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "شماره پیگیری",
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.rrn.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "شماره مرجع",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
//            Row {
//                Text(
//                    modifier = Modifier.weight(1f),
//                    text = "مشاهده",
//                    color = Color(0xFF2196F3),
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//
//                    text = "جزییات",
//                    fontSize = 16.sp
//                )
//
//            }

        }
        fun mapReportItemsToStats(items: List<DailyReportResponse>): List<DailyReportResponse> {
            // اگه دیتا نیومد یا ترتیبش درست نیست، همینطوری برگردون
            return items
        }
    }

}
